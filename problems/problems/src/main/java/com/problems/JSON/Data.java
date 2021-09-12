package com.problems.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Data {

    private static Data data;

    private List<MyFile> allFiles;
    private String jsonData;
    
    private Data(String json) {
        allFiles = new ArrayList<>();
        jsonData = json;
    }

    public List<MyFile> getAllFiles() {
        return allFiles;
    }

    private void loadFiles() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        this.allFiles =  Arrays.asList(mapper.readValue(jsonData, MyFile[].class));
    }

    public static Data getInstance(String json) throws Exception {
        if(data == null) {
            data = new Data(json);
            data.loadFiles();
        } else if(!json.equals(data.jsonData)) {
            data.jsonData = json;
            data.loadFiles();
        } 
        
        return data;
    }   
}