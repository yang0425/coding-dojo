package dojo.coding.fizzbuzz;

public class NumberPrinter {

  private NumberHandler handler = new NumberHandler();

  public void print(int number) {
    if (handler.isFizzBuzz(number)) {
      System.out.println("FizzBuzz");
    } else if (handler.isFizz(number)) {
      System.out.println("Fizz");
    } else if (handler.isBuzz(number)) {
      System.out.println("Buzz");
    } else {
      System.out.println(number);
    }
  }
}
