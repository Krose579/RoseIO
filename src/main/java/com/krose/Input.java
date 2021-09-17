package com.krose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Input {
    private static final int DEFAULT_INTEGER = 0;

    private static Input instance;

    public static Input getInstance() {
        if(instance == null) instance = new Input();
        return instance;
    }

    private BufferedReader bufferedReader;
    
    public Input() {
        this(new InputStreamReader(System.in));
    }

    public Input(Reader reader) {
        this.bufferedReader = new BufferedReader(reader);
    }

    public String getString() {
        return getString(null);
    }

    public String getString(String defaultValue) {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            return defaultValue;
        }
    }

    public int getInteger() {
        return getInteger(DEFAULT_INTEGER);
    }

    public int getInteger(int defaultValue) {
        while(true) {
            String input = getString();
            if(input == null) return defaultValue;
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                handleInputException(e);
            }
        }
    }

    private void handleInputException(Exception e) {
        Output.getInstance().write("Exception ocurred.");
    }
}