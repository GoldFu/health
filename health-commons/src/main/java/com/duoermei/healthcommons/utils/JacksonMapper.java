package com.duoermei.healthcommons.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static ObjectMapper getInstance() {
        return objectMapper;
    }
}