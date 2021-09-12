package com.problems.files;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MetaData {
    
    private String file;
    private int size;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> collectionId;


    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(List<String> collectionId) {
        this.collectionId = collectionId;
    }


    
}