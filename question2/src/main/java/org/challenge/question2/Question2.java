package org.challenge.question2;

public class Question2 {

  public static void main(String[] args) {
    if(args.length == 0) print_help(true);  // No arguments supplied
    if (args[0].equals("-h") || args[0].equals("--help")) print_help(false);

    String password = args[0];

    int missing_chars = countToSafe(password);

    System.out.println(missing_chars);
  }

  // Prints a help message and exit with correct status
  private static void print_help(boolean fail) {
    String help_text = "" +
            "usage: question2 [--help|-h] NUMBER_OF_LINES" + System.lineSeparator() +
            System.lineSeparator() +
            "This program tells how much characters are needed to a secure password" + System.lineSeparator() +
            System.lineSeparator() +
            "positional arguments:" + System.lineSeparator() +
            "  PASSWORD      the password to test" + System.lineSeparator() +
            System.lineSeparator() +
            "optional arguments:" + System.lineSeparator() +
            "  -h, --help  show this help message and exit" + System.lineSeparator() +
            System.lineSeparator() +
            "This application is part of Capgemini Brasil's trainee selection program." + System.lineSeparator();

    System.out.print(help_text);
    if (fail) System.exit(1);
    System.exit(0);
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