package com.problems.Graphs.CompressedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Kosaraju {
    
    Stack<String> kStack;
    Set<String> visitedNode;
    Map<String, List<String>> stronglyConnectedComponents;

    public Kosaraju(Map<String, List<String>> graph, Map<String, List<String>> reversedGraph) {
        kStack = new Stack<>();
        visitedNode = new HashSet<>();
        stronglyConnectedComponents = new HashMap<>();
        this.findStronglyConnectedComponents(graph, reversedGraph);
    }

    public Map<String, List<String>> getStronglyConnectedComponents() {
        return this.stronglyConnectedComponents;
    }


    private void findStronglyConnectedComponents(Map<String, List<String>> graph, Map<String, List<String>> reversedGraph) {
        for(String node:graph.keySet()) {
            if(!visitedNode.contains(node)) {
                DFSFirstPass(graph, node);
            }
        }        
        visitedNode.clear();

        while(kStack.size() > 0) {
            if(visitedNode.contains(kStack.peek())) {
                kStack.pop();
            } else {
                String node = kStack.pop();
                List<String> connectedComponents = new ArrayList<>();
                DFSSecondPass(reversedGraph, node, connectedComponents);
                this.stronglyConnectedComponents.put(node, connectedComponents);
            }
        }
        
    }

    private void DFSFirstPass(Map<String, List<String>> graph, String node) {
        if(visitedNode.contains(node)) {
            return;
        }
        visitedNode.add(node);
        if(graph.get(node) == null || graph.get(node).isEmpty()) {
            kStack.add(node);
            return;
        }
        Iterator<String> itr = graph.get(node).iterator();
        while(itr.hasNext()) {
            String newNode = itr.next();
            DFSFirstPass(graph, newNode);
        }
        kStack.add(node);
    }

    private void DFSSecondPass(Map<String, List<String>> rGraph, String node, List<String> connectedComponents) {
        if(visitedNode.contains(node)) {
            return;
        }
        visitedNode.add(node);
        connectedComponents.add(node);
        if(rGraph.get(node) == null || rGraph.get(node).isEmpty()) {
            return;
        } 
        Iterator<String> itr = rGraph.get(node).iterator();
        while(itr.hasNext()) {
            String newNode = itr.next();
            DFSSecondPass(rGraph, newNode, connectedComponents);
        }     

        
    }

}