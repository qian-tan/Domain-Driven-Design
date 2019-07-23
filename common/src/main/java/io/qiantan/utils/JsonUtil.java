package io.qiantan.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Objects;

/**
 * @author: yujiacheng
 * @date: 2019/7/2311:39 PM
 */
public abstract class JsonUtil {
    private static final ObjectMapper INDENT_OBJECT_MAPPER_NON_EMPTY = new ObjectMapper();
    private static final ObjectMapper INDENT_OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper NON_INDENT_OBJECT_MAPPER = new ObjectMapper();

    public JsonUtil() {
    }

    public static String getIndentJsonString(Object o) {
        if (Objects.isNull(o)) {
            return "";
        } else {
            try {
                return INDENT_OBJECT_MAPPER.writeValueAsString(o);
            } catch (Exception var2) {
                return o.toString();
            }
        }
    }

    static {
        INDENT_OBJECT_MAPPER_NON_EMPTY.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        INDENT_OBJECT_MAPPER_NON_EMPTY.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        INDENT_OBJECT_MAPPER_NON_EMPTY.enable(SerializationFeature.INDENT_OUTPUT);
        INDENT_OBJECT_MAPPER_NON_EMPTY.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        INDENT_OBJECT_MAPPER_NON_EMPTY.registerModule(new GuavaModule());
        INDENT_OBJECT_MAPPER.registerModule(new JavaTimeModule());
        INDENT_OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        INDENT_OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        INDENT_OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        NON_INDENT_OBJECT_MAPPER.registerModule(new JavaTimeModule());
        NON_INDENT_OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        NON_INDENT_OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}

