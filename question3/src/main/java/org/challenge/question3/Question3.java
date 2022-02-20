package org.challenge.question3;

import java.util.Arrays;

public class Question3 {

  public static void main(String[] args) throws Exception {
    String word = args[0];
    int pairs = 0;

    for (int i = 1; i < word.length(); i++) {
      pairs += substringAnagramCount(word, i);
    }

    System.out.println(pairs);
  }

  // Prints a help message and exit with correct status
  private static void print_help(boolean fail) {
    String help_text = "" +
            "usage: question3 [--help|-h] WORD" + System.lineSeparator() +
            System.lineSeparator() +
            "This program shows the number of anagram pairs of the substrings from a given word" + System.lineSeparator() +
            System.lineSeparator() +
            "positional arguments:" + System.lineSeparator() +
            "  WORD      the word from where the substrings are extracted" + System.lineSeparator() +
            System.lineSeparator() +
            "optional arguments:" + System.lineSeparator() +
            "  -h, --help  show this help message and exit" + System.lineSeparator() +
            System.lineSeparator() +
            "This application is part of Capgemini Brasil's trainee selection program." + System.lineSeparator();

    System.out.print(help_text);
    if (fail) System.exit(1);
    System.exit(0);
  }

  static int substringAnagramCount(String word, int delta) throws Exception {
    if (delta == word.length()) throw new Exception("delta and word length should not be equal");
    if (delta <= 0) throw new Exception("delta must be more than zero");

    int count = 0;
    for (int i = 0; i < word.length() - delta; i++) {
      String pivot_substring = word.substring(i, i + delta);

      for (int j = i + 1; j < word.length() - delta + 1; j++) {
        String substring = word.substring(j, j + delta);
        if (areAnagrams(pivot_substring, substring)) count++;
      }
    }
    return count;
  }

  static int charCount(Character letter, String word) {
    int index = word.indexOf(letter);
    int count = 0;

    while (index != -1) {
      index++;
      count++;
      index = word.indexOf(letter, index);
    }

    return count;
  }

  static boolean areAnagrams(String word1, String word2) {
    return Arrays.stream(word1.split(""))
            .map((c) -> c.charAt(0))
            .distinct()
            .map((c) -> charCount(c, word1) == charCount(c, word2)
                    && word1.length() == word2.length())
            .reduce(true, (partial, element) -> partial && element);
  }
}