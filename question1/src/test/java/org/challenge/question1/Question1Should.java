package org.challenge.question1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Question1Integration {

  // Question1 should print a message and exit without errors
  @Test
  void print_a_message() throws IOException, InterruptedException {
    // Build the Question1 subprocess
    ProcessBuilder builder = JavaProcess.exec(Question1.class);

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

    assertFalse(output.isEmpty());
    assertEquals(0, process.exitValue());
  }

}

class PrintLineShould {

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

  @Test
  void print_a_line() {
    Question1.print_line(1, 1);
    assertFalse(outContent.toString().isEmpty());
  }
}