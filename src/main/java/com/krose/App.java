package com.krose;

import com.krose.Output.Alignment;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String message = "Hello! My name is Kennon Rose and I am happy to welcome you to my program. I hope you enjoy the following input/output presentation.";
        Output.getInstance().setLength(50);
        Output.getInstance().writeDivider();
        Output.getInstance().write(message, Alignment.LEFT);
        Output.getInstance().writeDivider();
        Output.getInstance().write(message, Alignment.CENTER);
        Output.getInstance().writeDivider();
        Output.getInstance().write(message, Alignment.RIGHT);
        Output.getInstance().writeDivider();
    }
}
