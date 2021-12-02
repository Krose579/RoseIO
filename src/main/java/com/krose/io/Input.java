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

    private String getString() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean getBoolean() {
        String input = getString();
        if(input == null) return false;
        return Boolean.parseBoolean(input);
    }

    public Integer getInteger() {
        try {
            String input = getString();
            if (input != null) return Integer.parseInt(input);
        } catch (NumberFormatException ignored) {}
        return null;
    }

    public Double getDouble() {
        try {
            String input = getString();
            if (input != null) return Double.parseDouble(input);
        } catch (NumberFormatException ignored) {}
        return null;
    }
}