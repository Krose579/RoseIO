package com.krose.io;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class OutputTest {
    @Test
    public void testWrite() throws IOException {
        BufferedWriter mockBufferedWriter = mock(BufferedWriter.class);
        Output output = new Output(mockBufferedWriter);
        output.write("TEST");
        verify(mockBufferedWriter, times(1)).write("TEST");
        verify(mockBufferedWriter, times(1)).flush();
    }

    @Test
    public void testWriteLine() {
        BufferedWriter mockBufferedWriter = mock(BufferedWriter.class);
        Output output = new Output(mockBufferedWriter);
        Output spyOutput = spy(output);
        spyOutput.setLineLength(20);
        String originalValue = "THIS IS JUST A TEST. THIS IS JUST A TEST.";
        String expectedValue = "THIS IS JUST A TEST." + System.lineSeparator() + "THIS IS JUST A TEST." + System.lineSeparator();
        doNothing().when(spyOutput).write(any());
        spyOutput.writeLine(originalValue, Output.Alignment.LEFT);
        verify(spyOutput, times(1)).write(expectedValue);
    }

    @Test
    public void testWriteDivider() {
        BufferedWriter mockBufferedWriter = mock(BufferedWriter.class);
        Output output = new Output(mockBufferedWriter);
        Output spyOutput = spy(output);
        doNothing().when(spyOutput).write(any());
        spyOutput.writeDivider();
        verify(spyOutput, times(1)).write(any());
    }
}
