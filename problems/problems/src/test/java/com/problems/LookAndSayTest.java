package com.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class LookAndSayTest {


    public static Stream<Arguments> dataForFindLookAndSay() {
        return Stream.of(
            Arguments.of(3,"21" ),
            Arguments.of(4,"1211")
        );
    }

    private static Stream<Arguments> dataForDoLookAndSay() {
        return Stream.of(
                Arguments.of("11","21"),
                Arguments.of("21","1211")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForFindLookAndSay")
    public void findLookAndSayTest(int input, String expected)
    {
        com.problems.algos.LookAndSay ls = new com.problems.algos.LookAndSay();
        assertEquals( expected, ls.findLookAndSay(input-1) );
    }

    @ParameterizedTest
    @MethodSource("dataForDoLookAndSay")
    public void doLookAndSayTest(String input, String expected) {
        com.problems.algos.LookAndSay ls = new com.problems.algos.LookAndSay();
        assertEquals( expected, ls.doLookAndSay(input) );
    }
}