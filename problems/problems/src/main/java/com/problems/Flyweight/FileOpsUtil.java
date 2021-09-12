package com.problems.Flyweight;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileOpsUtil {
    
    public static int getParagraphCount(Stream<String> fileContent, final String fileType) {
        //StringBuilder contentBuilder = new StringBuilder();
        int paragraphCount = 0;
        if(fileContent == null) {
            return 0;
        }
        for(String s:fileContent.toArray(String[]::new)) {
            if(fileType.equalsIgnoreCase("txt") && s.isEmpty()) {
                paragraphCount++;                
            } else if(fileType.equalsIgnoreCase("csv") && s.isEmpty() ) {
                paragraphCount++;
            }
        }
        /*fileContent.forEach(s -> {
            
            contentBuilder.append(s).append("\n");
        });*/
        
        return paragraphCount;
    }

    public static Stream<String> getFileContent(final String filePathArg) {
        try (Stream<String> stream = Files.lines( Paths.get(filePathArg), StandardCharsets.UTF_8)) {
            return stream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}