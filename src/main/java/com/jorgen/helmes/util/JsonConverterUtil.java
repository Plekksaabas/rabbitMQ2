package com.jorgen.helmes.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonConverterUtil {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertMessageToJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
