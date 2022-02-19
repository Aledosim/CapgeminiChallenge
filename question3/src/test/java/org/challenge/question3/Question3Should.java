package org.challenge.question3;

import org.challenge.utils.JavaProcess;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Question3Integration {

  // Question3 should print a message and exit without errors
  @Test
  void print_a_message() throws IOException, InterruptedException {
    // Build the Question1 subprocess
    ProcessBuilder builder = JavaProcess.exec(Question3.class);

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

class AreAnagramsShould {

  // Given two Strings, if they have same chars at same quantity and have the same length, then they are anagrams
  @ParameterizedTest
  @CsvSource({
          "origem, meirog",
          "destino, sentido"
  })
  void return_true_for_anagrams(String word1, String word2) {
    boolean result = Question3.areAnagrams(word1, word2);
    assertTrue(result);
  }

  @ParameterizedTest
  @CsvSource({
          "origem, dmeirog",
          "destino, usentido",
          "ramo, rama"
  })
  void return_false_for_non_anagrams(String word1, String word2) {
    boolean result = Question3.areAnagrams(word1, word2);
    assertFalse(result);
  }
}

class CharCountShould {

  // charCount should return how many times a character appears in a string
  @ParameterizedTest
  @CsvSource({
          "o, ovo, 2",
          "e, freezer, 3",
          "i, pista, 1",
          "m, aeroporto, 0",
          "a, rama, 2",
          "a, ramo, 1"
  })
  void return_char_count_on_string (Character letter, String word, int expected) {
    int result = Question3.charCount(letter, word);
    assertEquals(expected, result);
  }
}