package com.krose;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Output {
    private static final int DEFAULT_LENGTH = 50;
    private static final char DEFAULT_SYMBOL = '-';

    private static Output instance;

    public static Output getInstance() {
        if(instance == null) instance = new Output();
        return instance;
    }

    private BufferedWriter bufferedWriter;
    private int length;
    private char dividerSymbol;

    public Output() {
        this(new OutputStreamWriter(System.out));
    }

    public Output(Writer writer) {
        this.bufferedWriter = new BufferedWriter(writer);
        this.length = DEFAULT_LENGTH;
        this.dividerSymbol = DEFAULT_SYMBOL;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDividerSymbol(char symbol) {
        this.dividerSymbol = symbol;
    }

    public void write(String output) {
        write(output, Alignment.LEFT);
    }

    public void write(String output, Alignment alignment) {
        // Separate output into lines in relation to length
        ArrayList<String> lines = new ArrayList<>();
        int startIndex = 0, endIndex = 0, currentIndex = 0;
        while(true) {
            if (startIndex + currentIndex == output.length()) {
                lines.add(output.substring(startIndex, startIndex + currentIndex).trim());
                break;
            } else if (currentIndex > length) {
                lines.add(output.substring(startIndex, endIndex).trim());
                startIndex = endIndex + 1;
                currentIndex = 0;
            } else {
                if (output.charAt(startIndex + currentIndex) == ' ') endIndex = startIndex + currentIndex;
                currentIndex++;
            }
        }
        // Print lines in relation to alignment
        int offset;
        for (String line : lines) {
            if (alignment == Alignment.LEFT) offset = 0;
            else {
                int diff = length - line.length();
                if (alignment == Alignment.CENTER) offset = diff / 2;
                else offset = diff;
            }
            for (int i = 0; i < offset; i++) tryWrite(" ");
            tryWrite(line);
            writeNewLine();
        } 
    }


    public void writeDivider() {
        writeDivider(dividerSymbol);
    }

    public void writeDivider(char symbol) {
        writeDivider(symbol, length);
    }

    public void writeDivider(char symbol, int length) {
        for(int i = 0; i < length; i++) tryWrite(String.valueOf(symbol));
        writeNewLine();
    }

    private void writeNewLine() {
        tryWrite(System.lineSeparator());
    }

    private void tryWrite(String output) {
        try {
            bufferedWriter.write(output);
            bufferedWriter.flush();
        } catch (IOException e) {}
    }

    public enum Alignment {
        LEFT, 
        CENTER,
        RIGHT
    }
}