package dojo.coding.fizzbuzz;

import java.util.stream.IntStream;

class FizzBuzz {

  public static void main(String[] args) {
    IntStream.range(1, 100).forEach(i -> System.out.println(FizzBuzz.of(i)));
  }

  static String of(int number) {
    if (isFizzBuzz(number)) {
      return "FizzBuzz";
    }
    if (isFizz(number)) {
      return "Fizz";
    }
    if (isBuzz(number)) {
      return "Buzz";
    }
    return String.valueOf(number);
  }

  private static boolean isFizzBuzz(int number) {
    return isFizz(number) && isBuzz(number);
  }

  private static boolean isBuzz(int number) {
    return number % 5 == 0 || String.valueOf(number).contains("5");
  }

  private static boolean isFizz(int number) {
    return number % 3 == 0 || String.valueOf(number).contains("3");
  }
}
