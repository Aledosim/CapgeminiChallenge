package org.challenge.question3;

import java.util.Arrays;

public class Question3 {

  public static void main(String[] args) {
    System.out.println("Hello World");
  }

  public static int charCount(Character letter, String word) {
    int index = word.indexOf(letter);
    int count = 0;

    while (index != -1) {
      index++;
      count++;
      index = word.indexOf(letter, index);
    }

    return count;
  }

  public static boolean areAnagrams(String word1, String word2) {
    return Arrays.stream(word1.split(""))
            .map((c) -> c.charAt(0))
            .distinct()
            .map((c) -> charCount(c, word1) == charCount(c, word2)
                    && word1.length() == word2.length())
            .reduce(true, (partial, element) -> partial && element);
  }
}