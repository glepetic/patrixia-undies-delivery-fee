package org.patrixia.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class JsonHandler {

    private static final ObjectMapper mapper = new ObjectMapper()
                    .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

    public static <T> T fromJson(String json) {
        try {
            return mapper.readValue(json, new TypeReference<T>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Could not read json");
        }
    }

}
