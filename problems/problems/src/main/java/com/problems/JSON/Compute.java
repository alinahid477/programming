package com.problems.JSON;

import java.util.List;
import java.util.stream.Collectors;

public class Compute {
    

    public int getTotalSize(String json) throws Exception {
        Data data = Data.getInstance(json);    
        Integer sum = data.getAllFiles().stream().collect(Collectors.summingInt(x->x.getSize()));    
        return sum.intValue();
    }

    public List<MyFile> getNCollection(String json, String collectionId, int n) throws Exception {
        Data data = Data.getInstance(json);
        return data.getAllFiles().stream().filter(x-> x.getCollectionId() != null && x.getCollectionId().equals(collectionId)).sorted((x,y)-> ((Integer)x.getSize()).compareTo((Integer)y.getSize()) ).limit(n).collect(Collectors.toList());
    }
}