package com.krose.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class InputTest {
    @Test
    public void testGetString() {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        Input input = new Input(mockBufferedReader);
        try {
            doReturn("TEST").when(mockBufferedReader).readLine();
            String result = input.getString();
            assertEquals("TEST", result);
            verify(mockBufferedReader, times(1)).readLine();
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testGetStringFailed() {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        Input input = new Input(mockBufferedReader);
        try {
            doThrow(new IOException("TEST")).when(mockBufferedReader).readLine();
            input.getString();
        } catch (IOException e) {
            assertEquals("TEST", e.getMessage());
        }
    }

    @Test
    public void testGetBoolean() {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        Input input = new Input(mockBufferedReader);
        Input spyInput = spy(input);
        try {
            doReturn("TRUE").when(spyInput).getString();
            boolean result = spyInput.getBoolean();
            assertTrue(result);
            verify(spyInput, times(1)).getString();
            clearInvocations(spyInput);
            doReturn("FALSE").when(spyInput).getString();
            result = spyInput.getBoolean();
            assertFalse(result);
            verify(spyInput, times(1)).getString();
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testGetBooleanFailed() {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        Input input = new Input(mockBufferedReader);
        Input spyInput = spy(input);
        try {
            doThrow(new IOException("TEST")).when(spyInput).getString();
            spyInput.getBoolean();
        } catch (IOException e) {
            assertEquals("TEST", e.getMessage());
        }
    }

    @Test
    public void testGetInteger() {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        Input input = new Input(mockBufferedReader);
        Input spyInput = spy(input);
        try {
            doReturn("1").when(spyInput).getString();
            int result = spyInput.getInteger();
            assertEquals(1, result);
            verify(spyInput, times(1)).getString();
            clearInvocations(spyInput);
            doReturn("10").when(spyInput).getString();
            result = spyInput.getInteger();
            assertEquals(10, result);
            verify(spyInput, times(1)).getString();
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testGetIntegerFailed() {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        Input input = new Input(mockBufferedReader);
        Input spyInput = spy(input);
        try {
            doThrow(new IOException("TEST")).when(spyInput).getString();
            spyInput.getInteger();
        } catch (IOException e) {
            assertEquals("TEST", e.getMessage());
        }
    }

    @Test
    public void testGetDouble() {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        Input input = new Input(mockBufferedReader);
        Input spyInput = spy(input);
        try {
            doReturn("1.5").when(spyInput).getString();
            double result = spyInput.getDouble();
            assertEquals(1.5, result, 0.01);
            verify(spyInput, times(1)).getString();
            clearInvocations(spyInput);
            doReturn("7.235").when(spyInput).getString();
            result = spyInput.getDouble();
            assertEquals(7.235, result,  0.0001);
            verify(spyInput, times(1)).getString();
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testGetDoubleFailed() {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        Input input = new Input(mockBufferedReader);
        Input spyInput = spy(input);
        try {
            doThrow(new IOException("TEST")).when(spyInput).getString();
            spyInput.getDouble();
        } catch (IOException e) {
            assertEquals("TEST", e.getMessage());
        }
    }
}
