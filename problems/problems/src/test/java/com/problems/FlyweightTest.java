package com.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import com.problems.Flyweight.FileFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FlyweightTest {
    
    public static FileFactory factory;

    @BeforeAll
    public static void init() {
        factory = FileFactory.getInstance();        
    }

    public static Stream<Arguments> filesdata() {
        return Stream.of(
            Arguments.of(new String[][] {{"l1\n\nl2","txt"}, {"l1\nl2","txt"}}, 1),
            Arguments.of(new String[][] {{"l1\nl2","txt"},{"l1\nl2", "txt"},{"1\r\n\r\n2","csv"},{"\r\nss\neee\r\nsss","docx"}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("filesdata")
    public void checkTotalNumberOFFileContentCreated(String[][] input, int expected) {
        for(String[] s : input) {
            String[] xx = s[0].split("\\n");
            factory.getParagraphCount(Arrays.asList(xx).stream(),s[1]);
        }
        assertEquals(expected, factory.getFilesSize(), String.format("EXPECTED %d FOUND %d", expected, factory.getFilesSize()));
    }
}