package org.challenge.question2;

import org.challenge.utils.JavaProcess;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Question2Integration {

  // Question2 should print a message and exit without errors
  @Test
  void print_a_message() throws IOException, InterruptedException {
    // Build the Question1 subprocess
    ProcessBuilder builder = JavaProcess.exec(Question2.class);

    // Starts the subprocess and wait for it fo finish
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

class CountToSixCharsShould {

  @ParameterizedTest
  @CsvSource({
          "Ya3, 3",
          "3(Vdx, 1",
          "[hRD97, 0",
          "ny8(*CS3, 0",
          "'', 6",
  })
  void return_missing_chars(String password, int expected){
    int result = Question2.countToSixChars(password);
    assertEquals(expected, result);
  }
}