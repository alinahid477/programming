package com.problems.Flyweight;

import java.util.stream.Stream;

public class CSVFileContent implements FileContent {
    
    // exsintric
    private Integer paragraphCount;

    // insintric
    private String fileType;

    public CSVFileContent() {
        this.fileType = "CSV";
    }

    

    public void calculateParagraphCount(final Stream<String> fileContent) {
        paragraphCount = FileOpsUtil.getParagraphCount(fileContent, this.fileType);
    }

    @Override
    public int getParagraphCount() {
        return this.paragraphCount;
    }

    
}