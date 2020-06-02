package com.codecool.filereader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    String filePath;
    int fromLine;
    int toLine;

    public FilePartReader() {
        filePath = "/dsa/";
        fromLine = 0;
        toLine = 0;
    }

    public void setup (String filePath, int fromLine, int toLine) {
        if (toLine < fromLine) throw new IllegalArgumentException();
        if (fromLine < 1) throw new IllegalArgumentException();

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

    }

    public String read () throws IOException {
        return Files.readString(Paths.get(filePath), StandardCharsets.US_ASCII);
    }

    public String readLines () throws IOException {
        StringBuilder actualLines = new StringBuilder();
        String text = read();
        String[] splittedText = text.split("\n");

        for (int counter = fromLine; counter <= toLine; counter++) {
            if (counter < toLine) {actualLines.append(splittedText[counter-1]).append("\n");}
            else {actualLines.append(splittedText[counter-1]);}
        }
        return actualLines.toString();

    }
}
