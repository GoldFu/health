package com.duoermei.healthcommons.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class JpaConverterJsonList implements AttributeConverter<List<Object>, String> {
    private static final ObjectMapper objectMapper = JacksonMapper.getInstance();

    @Override
    public String convertToDatabaseColumn(List<Object> attribute) {
        if (attribute == null) {
            return null;
        }

        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            log.error("Unexpected exception encoding json to database : " + attribute);
            return null;
        }
    }

    @Override
    public List<Object> convertToEntityAttribute(String column) {
        if (column == null) {
            return null;
        }
        try {
            return objectMapper.readValue(column, new TypeReference<List<Object>>() {
            });
        } catch (IOException e) {
            log.error("Unexpected exception decoding json from database: " + column);
            return null;
        }
    }
}