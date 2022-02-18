package org.challenge.question1;

public class Question1 {

  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  static void print_line(int line_length, int line_fill) {
    String fill = new String(new char[line_fill]).replace("\0", "*");
    System.out.printf("%" + (line_length + 1) + "s", fill + System.lineSeparator());
  }
}
