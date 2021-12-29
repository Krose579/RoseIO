package com.krose.io;

import com.google.inject.Inject;

import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.IOException;

@Singleton
public class Input {
    private final BufferedReader bufferedReader;

    @Inject
    public Input(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String getString() throws IOException {
        return bufferedReader.readLine();
    }

    public boolean getBoolean() throws IOException {
        return Boolean.parseBoolean(getString());
    }

    public int getInteger() throws IOException, NumberFormatException {
        return Integer.parseInt(getString());
    }

    public Double getDouble() throws IOException, NumberFormatException {
        return Double.parseDouble(getString());
    }
}