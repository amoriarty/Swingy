package fr.alegent.Swingy.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.alegent.Swingy.Swingy;
import lombok.val;

class JSONService {
    static final JSONService shared = new JSONService();
    private final ObjectMapper mapper = new ObjectMapper();

    <T> T get(String resource, Class<? extends T> asClass) {
        try {
            val url = Swingy.class.getResource(resource);
            return mapper.readValue(url, asClass);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private JSONService() { }
}
