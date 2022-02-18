package org.challenge.question1;

public class Question1 {

  public static void main(String[] args) {
    System.out.println("Hello world!");
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
