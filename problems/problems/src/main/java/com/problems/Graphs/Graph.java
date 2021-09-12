package com.problems.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Graph {

    Map<String, List<String>> graph;

    public Graph(String[] nodes, String[][] connectedNode) {
        graph = new HashMap<>();

        this.input(nodes, connectedNode);
    }

    public Map<String, List<String>> getGraph() {
        return this.graph;
    }

    private void input(String[] nodes, String[][] connectedNode) {
        this.graph = this.buildGraph(nodes, connectedNode);
        this.printGraph().stream().forEach(x->System.out.println(x));
    }

    private Map<String, List<String>> buildGraph(String[] nodes, String[][] connectedNode) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String node : nodes) {
            for (int i = 0; i < connectedNode.length; i++) {
                if (node.equalsIgnoreCase(connectedNode[i][0])) {
                    if (graph.get(node) == null) {
                        graph.put(node, new ArrayList<String>(Arrays.asList(connectedNode[i][1])));
                    } else {
                        graph.get(node).add(connectedNode[i][1]);
                    }                    
                }
            }
        }
        return graph;
    }


    public Map<String, List<String>> getReversedGraph() {
        Set<String> nodes = new HashSet<>();
        List<String[]> vertices = new ArrayList<>();
        for(Entry<String, List<String>> entry: this.graph.entrySet()) {
            nodes.add(entry.getKey());
            for(String dst: entry.getValue()) {
                nodes.add(dst);
                vertices.add(new String[]{dst,entry.getKey()});
            }
        }
        String[] x = nodes.stream().toArray(String[]::new);
        String[][] y = vertices.stream().toArray(String[][]::new);
        return buildGraph(x, y);
    }

    public List<String> printGraph() {
        return this.printGraph(graph);
    }

    public List<String> printGraph(Map<String, List<String>> graphArg) {
        List<String> printedGraph = new ArrayList<>();
        for(Entry<String, List<String>> entry: graphArg.entrySet()) {
            String s = entry.getKey()+"->";
            for(String n: entry.getValue()) {
                s += n+"->";        
            }
            s = s.substring(0,s.lastIndexOf("->"));
            printedGraph.add(s);
        }

        return printedGraph;
    }
}