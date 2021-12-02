package com.krose.io.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class SystemIOModule extends AbstractModule {
    @Provides
    public Reader provideReader() {
        return new InputStreamReader(System.in);
    }

    @Provides
    public Writer provideWriter() {
        return new OutputStreamWriter(System.out);
    }
}
