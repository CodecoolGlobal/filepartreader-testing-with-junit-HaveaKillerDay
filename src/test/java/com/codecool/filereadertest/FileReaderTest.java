package com.codecool.filereadertest;

import com.codecool.filereader.FilePartReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    @Test
    public void setupTest () {
        FilePartReader fileReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> fileReader.setup("test/resources/text/test.txt", 0, 0));
    }

    @Test
    public void readTest () throws IOException {
        FilePartReader fileReader = new FilePartReader();
        fileReader.setup("src/test/resources/text/test.txt", 1, 2);
        assertEquals("Gorillaz\nMandM\nYolo\nThing\nHello", fileReader.read());
    }
    @Test
    public void readLinesTest () throws IOException{
        FilePartReader fileReader = new FilePartReader();
        fileReader.setup("src/test/resources/text/test.txt", 1, 3);
        assertEquals("Gorillaz\nMandM\nYolo", fileReader.readLines());
    }
    @Test
    public void readLinesTestForOnlyTheFirstLine () throws IOException{
        FilePartReader fileReader = new FilePartReader();
        fileReader.setup("src/test/resources/text/test.txt", 1, 1);
        assertEquals("Gorillaz", fileReader.readLines());
    }
}
