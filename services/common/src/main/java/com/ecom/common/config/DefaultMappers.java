package com.ecom.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class DefaultMappers {
	public static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JavaTimeModule());
        jsonMapper.registerModule(new Jdk8Module());
        /*jsonMapper.getFactory().enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        jsonMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        jsonMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        jsonMapper.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        jsonMapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        jsonMapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        jsonMapper.registerModule(new JavaTimeModule());
        jsonMapper.registerModule(new Jdk8Module());
        SimpleModule simpleModule = new SimpleModule();
        jsonMapper.registerModule(simpleModule);*/
        return jsonMapper;
    }
}
