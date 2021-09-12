package com.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.problems.Graphs.Graph;
import com.problems.Graphs.CompressedGraph.Kosaraju;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class GraphTest {
    
    public static Stream<Arguments> graphdata() {
        return Stream.of(
            Arguments.of(new String[]{"a","b","c"}, new String[][]{ {"a","b"}, {"a","c"} }, new ArrayList<String>(Arrays.asList("a->b->c")), new ArrayList<String>(Arrays.asList("c->b->a")) ),
            Arguments.of(new String[]{"a","b","c","d"}, new String[][]{ {"a","b"}, {"b","c"}, {"a","d"}}, new ArrayList<String>(Arrays.asList("a->b->d","b->c")), new ArrayList<String>(Arrays.asList("d->b->a","c->b")) )
        );
    }

    public static Stream<Arguments> graphdata2() {
        return Stream.of(
            Arguments.of(new String[]{"a","b","c","d"}, new String[][]{ {"b","c"}, {"c","a"}, {"a","b"},{"b","d"} }, 2)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("graphdata")
    public void testGraphCapture(String[] nodes, String[][] vertices, List<String> expected, List<String> expectedRevered) {
        Graph graph = new Graph(nodes, vertices);
        List<String> actual = graph.printGraph();
        assertEquals(expected, actual, "list");
        List<String> actualReversed = graph.printGraph(graph.getReversedGraph());
        assertEquals(expectedRevered, actualReversed, "list");
    }

    
    @ParameterizedTest
    @MethodSource("graphdata2")
    public void connectedComponentTest(String[] nodes, String[][] vertices, int expected) {
        Graph graph = new Graph(nodes, vertices);
        Kosaraju kos = new Kosaraju(graph.getGraph(), graph.getReversedGraph());
        Map<String, List<String>> map = kos.getStronglyConnectedComponents();
        assertEquals(expected, map.size());
    }
}