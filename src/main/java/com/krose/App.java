package com.krose;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.krose.io.Input;
import com.krose.io.Output;
import com.krose.io.guice.SystemIOModule;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Injector injector = Guice.createInjector(new SystemIOModule());
        Input input = injector.getInstance(Input.class);
        Output output = injector.getInstance(Output.class);
        output.write("Hello");
        output.write(" ");
        output.write("World!");
        output.writeLine();
        output.writeLine("Some Title", Output.Alignment.CENTER);
        output.writeLine("Right!?", Output.Alignment.RIGHT);
        output.writeDivider('-');
        output.write("Enter Integer Value 1: ");
        int i1 = input.getInteger();
        output.writeLine("i1 = " + i1);
    }
}
