package org.challenge.question1;

public class Question1 {

  public static void main(String[] args) throws Exception {
    if(args.length == 0) print_help(true);  // No arguments supplied
    if (args[0].equals("-h") || args[0].equals("--help")) print_help(false);

    try {
      int n = Integer.parseInt(args[0]);
      for (int i = 1; i < n+1; i++) {
        print_line(n, i);
      }
    } catch (NumberFormatException e) {
      print_help(true);
    }

  }

  // Prints a help message and exit with correct status
  private static void print_help(boolean fail) {
    String help_text = "" +
            "usage: question1 [--help|-h] NUMBER_OF_LINES" + System.lineSeparator() +
            System.lineSeparator() +
            "This program prints a stair of *" + System.lineSeparator() +
            System.lineSeparator() +
            "positional arguments:" + System.lineSeparator() +
            "  NUMBER_OF_LINES      the height of the stair (the width is the same) " + System.lineSeparator() +
            System.lineSeparator() +
            "optional arguments:" + System.lineSeparator() +
            "  -h, --help  show this help message and exit" + System.lineSeparator() +
            System.lineSeparator() +
            "This application is part of Capgemini Brasil's trainee selection program." + System.lineSeparator();

    System.out.print(help_text);
    if (fail) System.exit(1);
    System.exit(0);
  }

  static void print_line(int line_length, int line_fill) throws Exception {
    if (line_length < 1) {
      throw new Exception("line_length less than 1");
    } else if (line_fill < 1) {
      throw new Exception("Invalid line_fill value: " + line_fill);
    } else if (line_fill > line_length) {
    throw new Exception("line_fill is greater than line_length");
  }

  String fill = new String(new char[line_fill]).replace("\0", "*");
  System.out.printf("%" + (line_length + 1) + "s", fill + System.lineSeparator());
  }
}
