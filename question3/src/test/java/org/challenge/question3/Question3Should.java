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

  // Question3 should print the number of anagrams pairs of substrings
  @ParameterizedTest
  @CsvSource({
          "ovo, 3",
          "ifailuhkqq, 3"
  })
  void print_number_of_anagrams_pairs(String input, int expected) throws IOException, InterruptedException {
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

    assertEquals(expected, String.join(System.lineSeparator(), output));
    assertEquals(0, process.exitValue());
  }
}

class SubstringAnagramCountShould {

  // Returns the number of substring pairs that are anagrams
  @ParameterizedTest
  @CsvSource({
          "ovo, 1, 1",
          "ovo, 2, 1",
          "ifailuhkqq, 1, 2",
          "ifailuhkqq, 2, 0",
          "ifailuhkqq, 3, 1",
          "ifailuhkqq, 4, 0",
          "ifailuhkqq, 5, 0",
          "ifailuhkqq, 6, 0",
          "ifailuhkqq, 7, 0",
          "ifailuhkqq, 8, 0",
          "ifailuhkqq, 9, 0",

  })
  void return_number_of_anagrams_pairs(String word, int delta, int expected) throws Exception {
    int result = Question3.substringAnagramCount(word, delta);

    assertEquals(expected, result);
  }

  // Raises Exception if delta equals word length
  @Test
  void raises_exception_when_delta_equals_word_length() {
    Exception result = assertThrows(Exception.class, () -> Question3.substringAnagramCount("ovo", 3));
    assertEquals("delta and word length should not be equal", result.getMessage());
  }

  // Raises Exception if delta is less than 0
  @Test
  void raises_exception_when_delta_less_than_zero() {
    Exception result = assertThrows(Exception.class, () -> Question3.substringAnagramCount("ovo", 0));
    assertEquals("delta must be more than zero", result.getMessage());
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