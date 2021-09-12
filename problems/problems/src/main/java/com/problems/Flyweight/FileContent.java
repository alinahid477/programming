package com.problems.Flyweight;

import java.util.stream.Stream;

public interface FileContent {
    public void calculateParagraphCount(final Stream<String> fileContent);
    public int getParagraphCount();
}