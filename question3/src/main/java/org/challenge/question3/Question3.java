package org.challenge.question3;

import java.util.List;

public class Question3 {

  public static void main(String[] args) {
    System.out.println("Hello World");
  }

  public static int charCount(char letter, String word) {
    int index = word.indexOf(letter, 0);
    int count = 0;

    while (index != -1) {
      index++;
      count++;
      index = word.indexOf(letter, index);
    }

    return count;
  }
}