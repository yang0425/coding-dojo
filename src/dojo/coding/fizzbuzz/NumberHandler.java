package dojo.coding.fizzbuzz;

public class NumberHandler {

  public boolean isFizz(int number) {
    return number % 3 == 0 || String.valueOf(number).contains("3");
  }

  public boolean isBuzz(int number) {
    return number % 5 == 0 || String.valueOf(number).contains("5");
  }

  public boolean isFizzBuzz(int number) {
    return isFizz(number) && isBuzz(number);
  }
}
