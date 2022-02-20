package org.challenge.question2;

public class Question2 {

  public static void main(String[] args) {
    String password = args[0];

    int missing_chars = countToSafe(password);

    System.out.println(missing_chars);
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