package com.sahaj.tambola;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;


public class AppTest {
    @Test
    void testMainMethodOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        String expectedOutput = "Claim for First Column: Accepted" + System.lineSeparator();

        try {
            App.main(new String[]{});
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            System.setOut(originalOut);
        }
    }
}