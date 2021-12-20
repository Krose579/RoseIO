package com.krose.io;

import com.google.inject.Inject;

import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

@Singleton
public final class Input {
    private final BufferedReader bufferedReader;

    @Inject
    public Input(Reader reader) {
        this.bufferedReader = new BufferedReader(reader);
    }

    public String getString() throws IOException {
        return bufferedReader.readLine();
    }

    public boolean getBoolean() throws IOException {
        String input = getString();
        return Boolean.parseBoolean(input);
    }

    public int getInteger() throws IOException, NumberFormatException {
        return Integer.parseInt(getString());
    }

    public Double getDouble() throws IOException, NumberFormatException {
        return Double.parseDouble(getString());
    }
}