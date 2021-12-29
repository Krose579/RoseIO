package com.krose.io.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.io.*;

public class SystemIOModule extends AbstractModule {
    @Provides
    public Reader provideReader() {
        return new InputStreamReader(System.in);
    }

    @Provides
    public BufferedReader provideBufferedReader(Reader reader) {
        return new BufferedReader(reader);
    }

    @Provides
    public Writer provideWriter() {
        return new OutputStreamWriter(System.out);
    }

    @Provides
    public BufferedWriter provideBufferedWriter(Writer writer) {
        return new BufferedWriter(writer);
    }
}
