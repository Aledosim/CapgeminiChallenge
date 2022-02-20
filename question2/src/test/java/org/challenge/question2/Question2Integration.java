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

class HasDigitShould {

  @ParameterizedTest
  @CsvSource({
          "Ya3, true",
          "3(Vdx, true",
          "DG*qhW, false",
          "'', false",
  })
  void return_if_it_has_at_least_one_digit(String password, boolean expected){
    boolean result = Question2.hasDigit(password);
    assertEquals(expected, result);
  }
}

class HasCapitalLetterShould {

  @ParameterizedTest
  @CsvSource({
          "Ya3, true",
          "3(Vdx, true",
          "b2$nr%0, false",
          "5w%hj, false",
          "'', false",
  })
  void return_if_it_has_at_least_one_capital_letter(String password, boolean expected){
    boolean result = Question2.hasCapitalLetter(password);
    assertEquals(expected, result);
  }
}

class HasLowerLetterShould {

  @ParameterizedTest
  @CsvSource({
          "Ya3, true",
          "3(Vdx, true",
          "!@X5GS, false",
          "657T)QZ!A, false",
          "E@JM28, false",
          "'', false",
  })
  void return_if_it_has_at_least_one_lower_case_letter(String password, boolean expected){
    boolean result = Question2.hasLowerLetter(password);
    assertEquals(expected, result);
  }
}

class HasSpecialCharShould {

  @ParameterizedTest
  @CsvSource({
          "Ya3, false",
          "9wkcWc, false",
          "3(Vdx, true",
          "!X5GS, true",
          "Hk8t@fd, true",
          "657T)QZA, true",
          "NKSsD^, true",
          "563#f9RMhg, true",
          "b2$nr0, true",
          "fgh%5EBT, true",
          "2&bD3cN, true",
          "W35F-Mkphf, true",
          "3YSdDg+pbkqnE, true",
          "ny8*CS3, true",
          "'', false",
  })
  void return_if_it_has_at_least_one_special_character(String password, boolean expected){
    boolean result = Question2.hasSpecialChar(password);
    assertEquals(expected, result);
  }
}

class CountToSafeShould {

  @ParameterizedTest
  @CsvSource({
          "Ya3, 3",
          "5w%hj, 1",
          "Z8Q@, 2",
          "cX-jk, 1",
          "!@X5GS, 1",
          "b2$nr%0, 1",
          "DG*qhW, 1",
          "e7yWZpR9e, 1",
          "[hRD97, 1",
          "ny8(*CS3, 0",
          "'', 6",
  })
  void return_number_of_missing_characters_to_safe_password(String password, int expected){
    int result = Question2.countToSafe(password);
    assertEquals(expected, result);
  }
}
