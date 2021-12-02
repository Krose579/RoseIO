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

    public String getString() {
        int retryCount = 3;
        while (retryCount > 0) {
            try {
                return bufferedReader.readLine();
            } catch (IOException ignored) {}
            retryCount--;
        }
        return "";
    }

    public boolean getBoolean() {
        return Boolean.parseBoolean(getString());
    }

    public Integer getInteger() {
        try {
            Integer.parseInt(getString());
        } catch (NumberFormatException ignored) {}
        return null;
    }

    public Double getDouble() {
        try {
            return Double.parseDouble(getString());
        } catch (NumberFormatException ignored) {}
        return null;
    }
}