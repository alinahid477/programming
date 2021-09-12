package com.problems.Flyweight;

import java.util.stream.Stream;

public class TXTFileContent implements FileContent {
    
    // exsintric
    private int paragraphCount;

    // insintric
    private String fileType;

    public TXTFileContent() {
        this.fileType = "TXT";
    }

    public int getParagraphCount() {
        return paragraphCount;
    }

    @Override
    public void calculateParagraphCount(final Stream<String> fileContent) {
        this.paragraphCount = FileOpsUtil.getParagraphCount(fileContent, this.fileType);
    }

}