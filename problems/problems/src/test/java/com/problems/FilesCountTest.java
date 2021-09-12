package com.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import com.problems.JSON.Compute;
import com.problems.files.FileReader;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FilesCountTest {

    public static Stream<Arguments> data() {
        return Stream.of(Arguments.of(
                "[   {file: \"file1.txt\", size: 100},   {file: \"file2.txt\", size: 200, collectionId: \"collection1\"},   {file: \"file3.txt\", size: 200, collectionId: \"collection1\"},   {file: \"file4.txt\", size: 300, collectionId: \"collection2\"},   {file: \"file5.txt\", size: 10} ]",
                510));
    }

    public static Stream<Arguments> datahierarchy() {
        return Stream.of(Arguments.of(
                "[   {collection: \"collection1\"},   {collection: \"collection2\", parentCollectionId: \"collection1\"},   {collection: \"collection4\", parentCollectionId: \"collection1\"},   {collection: \"collection3\", parentCollectionId: \"collection2\"}   ]",
                2));
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    public void testTotalFileSize(String json, int extpectedSize) {
        Compute c = new Compute();
        try {
            int actualsize = c.getTotalSize(json);
            assertEquals(extpectedSize, actualsize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    public void generateReportforAllCollectionTest(String json, int extpectedSize) {
        try {
            FileReader fr = new FileReader();
            fr.readFile(json);
            fr.generateReportforAllCollection(2);
        }catch(Exception e) {

        }
    }


    @ParameterizedTest
    @MethodSource("datahierarchy")
    public void readHierarchyTest(String input, int expected) {
        try{
            FileReader fr = new FileReader();
            fr.readHierarchy(input);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    
}