package org.challenge.question1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Question1Integration {

  // Question1 should print a stair and exit without errors
  @Test
  void print_stairs_and_exit() throws IOException, InterruptedException {
    String expected = "     *" + System.lineSeparator() +
                      "    **" + System.lineSeparator() +
                      "   ***" + System.lineSeparator() +
                      "  ****" + System.lineSeparator() +
                      " *****" + System.lineSeparator() +
                      "******";
    int input = 6;

    // Build the Question1 subprocess
    ProcessBuilder builder = JavaProcess.exec(Question1.class, Collections.singletonList(String.valueOf(input)));

    // Starts the subprocess and wait for it to finish
    Process process = builder.start();
    process.waitFor();

    // Read the stdout of the subprocess and writes it in a List
    BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
    List<String> output = new ArrayList<>();
    String line;
    while ((line = in.readLine()) != null) {
      output.add(line);
    }
    in.close();

    assertEquals(expected, String.join(System.lineSeparator(), output));
    assertEquals(0, process.exitValue());
  }

}

class PrintLineShould {

  // Redirecting stdout
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @ParameterizedTest
  @CsvSource({
          "1, 1, *",
          "3, 1, '  *'",
          "6, 4, '  ****'"
  })
  void print_a_filled_line(int line_length, int line_fill, String expected) throws Exception {
    Question1.print_line(line_length, line_fill);
    assertEquals(expected + System.lineSeparator(), outContent.toString());
  }

  @Test
  void raise_exception_with_invalid_parameter_input() {
    Exception result;

    // Minimal value for line_length is 1
    result = assertThrows(Exception.class, () -> Question1.print_line(0, 1));
    assertEquals("line_length less than 1", result.getMessage());

    // Minimal value for line_fill is 1
    result = assertThrows(Exception.class, () -> Question1.print_line(5, 0));
    assertEquals("Invalid line_fill value: 0", result.getMessage());

    // Maximum value for line_fill is line_length
    result = assertThrows(Exception.class, () -> Question1.print_line(10, 11));
    assertEquals("line_fill is greater than line_length", result.getMessage());
  }
}