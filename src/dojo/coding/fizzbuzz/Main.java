package dojo.coding.fizzbuzz;

import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    NumberPrinter printer = new NumberPrinter();
    IntStream.range(1, 100).forEach(printer::print);
  }

}
