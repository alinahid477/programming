package com.problems.Flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileFactory {
    
    public static FileFactory factory;

    private List<FileContent> files = null;

    private FileFactory() {
        files = new ArrayList<>();
    }

    public static FileFactory getInstance() {
        if(factory == null) {
            factory = new FileFactory();
        }
        return factory;
    }


    public int getParagraphCount(Stream<String> fileContent, String fileType) {
        FileContent file = this.getFileContentObject(fileType);
        if(file != null) {
            file.calculateParagraphCount(fileContent);
            return file.getParagraphCount();
        }
        return -1;
    }

    public int getParagraphCount(String filePathArg) {
        String fileExt = filePathArg.substring(filePathArg.lastIndexOf('.'));
        Stream<String> fileContent = FileOpsUtil.getFileContent(filePathArg);
        return this.getParagraphCount(fileContent, fileExt);
    }

    private FileContent getFileContentObject(String fileType) {
        FileContent file = null;
        for(FileContent fc : files) {
            if(fileType.equalsIgnoreCase("csv") && fc instanceof CSVFileContent) {
                return fc;
            } else if(fileType.equalsIgnoreCase("txt") && fc instanceof TXTFileContent) {
                return fc;
            }
        }
        if(file == null) {
            if(fileType.equalsIgnoreCase("csv")) {
                file = new CSVFileContent();
            } else if(fileType.equalsIgnoreCase("txt")) {
                file = new TXTFileContent();
            }
        }
        if(file != null) {
            files.add(file);
        }
        return file;
    }

    public int getFilesSize() {
        return files.size();
    }
}