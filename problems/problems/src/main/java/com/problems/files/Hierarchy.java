package com.problems.files;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Hierarchy {
    private String collection;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parentCollectionId;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getParentCollectionId() {
        return parentCollectionId;
    }

    public void setParentCollectionId(String parentCollectionId) {
        this.parentCollectionId = parentCollectionId;
    }

    
}