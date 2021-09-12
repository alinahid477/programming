package com.problems.files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FileReader {
    
    List<MetaData> files;

    Map<String, List<String>> hierarchyMap;
    List<Hierarchy> hierarchyList;

    public FileReader() throws Exception {
        files = new ArrayList<>();
        hierarchyMap = new HashMap<>();
    }

    public void readFile(String jsonData) throws Exception {
        if(jsonData.isEmpty()) {
            return;
        }        
        this.files = Arrays.asList(JacksonObjectMapperFactory.getInstance().getObjectMapper("json").readValue(jsonData, MetaData[].class));
        this.files = this.files.stream().filter(x->x.getCollectionId()!=null && !x.getCollectionId().isEmpty()).sorted((x,y)-> ((Integer)x.getSize()).compareTo((Integer)y.getSize())).collect(Collectors.toList());
    }

    public void readHierarchy(String jString) throws Exception {
        if(jString.isEmpty()) {
            return;
        }        
        this.hierarchyList = Arrays.asList(JacksonObjectMapperFactory.getInstance().getObjectMapper("json").readValue(jString, Hierarchy[].class));
        Optional<Hierarchy> tmp = hierarchyList.stream().filter(x->x.getParentCollectionId() == null).findFirst();
        if(!tmp.isPresent()) {
            throw new Exception("root not found");
        }
        this.buildGraph(tmp.get().getCollection());
    }


    private void buildGraph(String parent) {

        for(Hierarchy h: hierarchyList) {
            if(h.getParentCollectionId()!=null) {
                if(h.getParentCollectionId().equals(parent)) { 
                    if(this.hierarchyMap.get(parent) == null) {
                        this.hierarchyMap.put(parent, new ArrayList<String>());
                    }
                    this.hierarchyMap.get(parent).add(h.getCollection());

                    buildGraph(h.getCollection());
                }
            }
            
        }
    }
    public Map<String, Integer> generateReportforAllCollectionsByHierarchy() {
        Map<String, Integer> collectionByHierarchyMap = new HashMap<>();
        Map<String, Integer> collectionMap = this.generateReportforAllCollection();
        List<Hierarchy> rootsOnly = this.hierarchyList.stream().filter(x->x.getParentCollectionId() == null).collect(Collectors.toList());
        for(Hierarchy h: rootsOnly) {
            this.getCollecitonWeight(collectionMap, h.getCollection(), collectionByHierarchyMap);
        }
        return collectionByHierarchyMap;
    }

    public int getCollecitonWeight(Map<String, Integer> collectionMap, String parent, Map<String, Integer> collectionByHierarchyMap) {

        if(this.hierarchyMap.get(parent) == null) {
            collectionByHierarchyMap.put(parent, collectionMap.get(parent));
            return collectionMap.get(parent);
        }    

        int thisSize = collectionMap.get(parent); 
        for(String node: this.hierarchyMap.get(parent)) {
            thisSize += this.getCollecitonWeight(collectionMap, node, collectionByHierarchyMap);
        }
        collectionByHierarchyMap.put(parent, thisSize);
        return thisSize;
    }


    public int generateReportforACollection(String collecitonName) { 
        Set<String> seenFiles = new HashSet<>();
        int size = 0;
        for(MetaData file: files) {
            if(!seenFiles.contains(file.getFile()) && file.getCollectionId().stream().anyMatch(x->{
                boolean equals = x.equals(collecitonName);
                return equals;
            })) {
                size += file.getSize();
            }
        }

        return size;
    }


    public Map<String, Integer> generateReportforAllCollection() {
        Map<String, Integer> collectionMap = new HashMap<>();
        Set<String> seenFiles = new HashSet<>();

        for(MetaData file: files) {
            if(seenFiles.contains(file.getFile())) {
                continue;
            }
           
            Optional<String> key = collectionMap.keySet().stream().filter(x->file.getCollectionId().contains(x)).findFirst();
            if(!key.isPresent()) {
                key = Optional.of(file.getCollectionId().get(0));
                collectionMap.put(file.getCollectionId().get(0), 0);
            }      
            
            collectionMap.put(key.get(), collectionMap.get(key.get())+file.getSize());
        }

        return collectionMap;
    }
}




