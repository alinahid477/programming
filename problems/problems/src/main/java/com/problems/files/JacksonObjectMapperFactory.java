package com.problems.files;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonObjectMapperFactory {
    
    private static JacksonObjectMapperFactory thisObject;
    
    ObjectMapper jsonMapper;
    private JacksonObjectMapperFactory() {
        jsonMapper = new ObjectMapper();
        jsonMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }
    
    public static JacksonObjectMapperFactory getInstance() {
        if(thisObject == null) {
            thisObject = new JacksonObjectMapperFactory();
        }
        return thisObject;
    }

    public ObjectMapper getObjectMapper(String forObject) {
        switch(forObject) {
            case "json":
                return this.jsonMapper;
            default:
                break;
        }
        return null;
    }
}