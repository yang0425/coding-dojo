package dojo.coding.fizzbuzz;

import java.util.stream.IntStream;

class FizzBuzz {

  public static void main(String[] args) {
    IntStream.range(1, 100).forEach(i -> System.out.println(FizzBuzz.of(i)));
  }

  static String of(int input) {
    if (isFizzBuzz(input)) {
      return "FizzBuzz";
    }
    if (isFizz(input)) {
      return "Fizz";
    }
    if (isBuzz(input)) {
      return "Buzz";
    }
    return String.valueOf(input);
  }

  private static boolean isFizzBuzz(int input) {
    return isFizz(input) && isBuzz(input);
  }

  private static boolean isBuzz(int input) {
    return input % 5 == 0 || String.valueOf(input).contains("5");
  }

  private static boolean isFizz(int input) {
    return input % 3 == 0 || String.valueOf(input).contains("3");
  }
}
