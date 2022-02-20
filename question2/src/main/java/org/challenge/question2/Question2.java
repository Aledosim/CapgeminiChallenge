package org.challenge.question2;

public class Question2 {

  public static void main(String[] args) {
    System.out.println("Hello World");
  }

  public static int countToSixChars(String password) {
    if (password.length() >= 6) return 0;
    return 6 - password.length();
  }

  public static boolean hasADigit(String password) {
    return password.matches(".*\\d+.*");
  }

  public static boolean hasACapitalLetter(String password) {
    return password.matches(".*[A-Z]+.*");
  }

  public static boolean hasALowerLetter(String password) {
    return password.matches(".*[a-z]+.*");
  }

  public static boolean hasASpecialChar(String password) {
    // Special characters are !@#$%^&*()-+
    String special_chars = "!@#\\$%\\^&*\\(\\)\\-\\+";

    return password.matches(".*[" + special_chars + "]+.*");
  }
}