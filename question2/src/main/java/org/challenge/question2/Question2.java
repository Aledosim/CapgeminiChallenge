package org.challenge.question2;

public class Question2 {

  public static void main(String[] args) {
    System.out.println("Hello World");
  }

  public static int countToSixChars(String password) {
    if (password.length() >= 6) return 0;
    return 6 - password.length();
  }
}