package fr.alegent.Swingy.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.alegent.Swingy.Swingy;
import lombok.val;

import java.io.File;
import java.net.URL;

public class ResourcesService {
    public static final ResourcesService shared = new ResourcesService();
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T get(String resource, Class<? extends T> asClass) throws Exception {
        val url = Swingy.class.getResource(resource);
        return get(url, asClass);
    }

    public <T> T get(URL url, Class<? extends T> asClass) throws Exception {
        return mapper.readValue(url, asClass);
    }

    <T> void write(File file, T content) throws Exception {
        mapper.writeValue(file, content);
    }

    private ResourcesService() { }

}
