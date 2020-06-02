package com.codecool.filereader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader fileReader;

    public FileWordAnalyzer (FilePartReader fileReader) {
        this.fileReader = fileReader;
    }

    public List getWordsOrderedAlphabetically () throws IOException {
        String lines = fileReader.readLines();
        ArrayList<String> wordsAsArrayList = new ArrayList<>();

        String[] wordsAsArray = lines.split("\n");
        Collections.addAll(wordsAsArrayList, wordsAsArray);

        Collections.sort(wordsAsArrayList);
        return wordsAsArrayList;
    }

    public List getWordsContainingSubstring (String subString) throws IOException {
        String lines = fileReader.readLines();
        String[] wordsAsArray = lines.split("\n");
        ArrayList<String> result = new ArrayList<>();
        for (String word : wordsAsArray) {
            if (word.toLowerCase().contains(subString.toLowerCase())) {
                result.add(word);
            }
        }
        return result;
    }

    public List getStringsWhichPalindromes () throws IOException {
        String lines = fileReader.readLines();
        String[] wordsAsArray = lines.split("\n");
        ArrayList<String> result = new ArrayList<>();
        for (String word : wordsAsArray) {
            boolean isWordPalindrome = isPalindrome(word);
            if (isWordPalindrome) result.add(word);
        }
        return result;
    }

    private boolean isPalindrome (String word) {
        int i = 0, j = word.length() - 1;

        while (i < j) {

            if (word.charAt(i) != word.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

}
