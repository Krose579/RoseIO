package com.krose.io;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

@Singleton
public class Output {
    private int lineLength;
    private char dividerSymbol;
    private final BufferedWriter bufferedWriter;

    @Inject
    public Output(BufferedWriter bufferedWriter) {
        this.lineLength = 50;
        this.dividerSymbol = '#';
        this.bufferedWriter = bufferedWriter;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    public char getDividerSymbol() {
        return dividerSymbol;
    }

    public void setDividerSymbol(char dividerSymbol) {
        this.dividerSymbol = dividerSymbol;
    }

    public void write(String output) {
        try {
            bufferedWriter.write(output);
            bufferedWriter.flush();
        } catch (IOException ignored) {}
    }

    public void writeLine() {
        writeLine(null);
    }

    public void writeLine(String output) {
        writeLine(output, Alignment.LEFT);
    }

    public void writeLine(String output, Alignment alignment) {
        StringBuilder stringBuilder = new StringBuilder();
        if (output == null) stringBuilder.append(System.lineSeparator());
        else {
            ArrayList<String> lines = new ArrayList<>();
            int startIndex = 0, endIndex = 0, currentIndex = 0;
            while(true) {
                if (startIndex + currentIndex == output.length()) {
                    lines.add(output.substring(startIndex, startIndex + currentIndex).trim());
                    break;
                } else if (currentIndex > getLineLength()) {
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
                    int diff = getLineLength() - line.length();
                    if (alignment == Alignment.CENTER) offset = diff / 2;
                    else offset = diff;
                }
                stringBuilder.append(" ".repeat(Math.max(0, offset)));
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        }
        write(stringBuilder.toString());
    }

    public void writeDivider() {
        writeDivider(getDividerSymbol());
    }

    public void writeDivider(char symbol) {
        write(String.valueOf(symbol).repeat(Math.max(0, getLineLength())) + System.lineSeparator());
    }

    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT
    }
}