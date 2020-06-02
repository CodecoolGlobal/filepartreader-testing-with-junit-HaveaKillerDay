package com.codecool.filereadertest;

import com.codecool.filereader.FilePartReader;
import com.codecool.filereader.FileWordAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {

    FilePartReader fileReader;
    FileWordAnalyzer fileAnalyzer;
    ArrayList<String> expectedResultForAlphabeticSort;

    @BeforeEach
    public void setupForTheTests () {
        fileReader = new FilePartReader();
        fileReader.setup("src/test/resources/text/test.txt", 1, 5);
        fileAnalyzer = new FileWordAnalyzer(fileReader);
        expectedResultForAlphabeticSort = new ArrayList<>();
        expectedResultForAlphabeticSort.add("Gorillaz");
        expectedResultForAlphabeticSort.add("Hello");
        expectedResultForAlphabeticSort.add("MaM");
        expectedResultForAlphabeticSort.add("Thing");
        expectedResultForAlphabeticSort.add("YoloY");
    }

    @Test
    public void setupTest () {
        assertThrows(IllegalArgumentException.class, () -> fileReader.setup("test/resources/text/test.txt", 0, 0));
    }

    @Test
    public void readTest () throws IOException {
        fileReader.setup("src/test/resources/text/test.txt", 1, 2);
        assertEquals("Gorillaz\nMaM\nYoloY\nThing\nHello", fileReader.read());
    }

    @Test
    public void readLinesTest () throws IOException{
        fileReader.setup("src/test/resources/text/test.txt", 1, 3);
        assertEquals("Gorillaz\nMaM\nYoloY", fileReader.readLines());
    }

    @Test
    public void readLinesTestForOnlyTheFirstLine () throws IOException{
        fileReader.setup("src/test/resources/text/test.txt", 1, 1);
        assertEquals("Gorillaz", fileReader.readLines());
    }

    @Test
    public void alphabeticOrderTest () throws IOException {
        assertEquals(expectedResultForAlphabeticSort,fileAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void FileContainsSubStringTest () throws IOException {
        ArrayList<String> resultForSubStringTest = new ArrayList<>();
        resultForSubStringTest.add("YoloY");
        resultForSubStringTest.add("Hello");
        assertEquals(resultForSubStringTest, fileAnalyzer.getWordsContainingSubstring("lo"));
    }

    @Test
    public void isThereAnyPalindrome () throws IOException {
        ArrayList<String> resultForPalindromeTest = new ArrayList<>();
        resultForPalindromeTest.add("MaM");
        resultForPalindromeTest.add("YoloY");
        assertEquals(resultForPalindromeTest, fileAnalyzer.getStringsWhichPalindromes());
    }
}
