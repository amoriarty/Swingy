package fr.alegent.Swingy.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.alegent.Swingy.Swingy;
import lombok.val;

public class ResourcesService {
    public static final ResourcesService shared = new ResourcesService();
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T get(String resource, Class<? extends T> asClass) throws Exception {
        val url = Swingy.class.getResource(resource);
        return mapper.readValue(url, asClass);
    }

    private ResourcesService() { }
}
