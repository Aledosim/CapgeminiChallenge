package org.challenge.question2;

public class Question2 {

  public static void main(String[] args) {
    System.out.println("Hello World");
  }

  public static int countToSixChars(String password) {
    if (password.length() >= 6) return 0;
    return 6 - password.length();
  }

  public static boolean hasDigit(String password) {
    return password.matches(".*\\d+.*");
  }

  public static boolean hasCapitalLetter(String password) {
    return password.matches(".*[A-Z]+.*");
  }

  public static boolean hasLowerLetter(String password) {
    return password.matches(".*[a-z]+.*");
  }

  public static boolean hasSpecialChar(String password) {
    // Special characters are !@#$%^&*()-+
    String special_chars = "!@#\\$%\\^&*\\(\\)\\-\\+";

    return password.matches(".*[" + special_chars + "]+.*");
  }

  public static int countToSafe(String password) {
    if (password.length() < 6) return 6 - password.length();

    int count = 0;
    if (!hasDigit(password)) count++;
    if (!hasLowerLetter(password)) count++;
    if (!hasCapitalLetter(password)) count++;
    if (!hasSpecialChar(password)) count++;

    return count;
  }
}