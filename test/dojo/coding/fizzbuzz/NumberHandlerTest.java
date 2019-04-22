package dojo.coding.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberHandlerTest {

  private NumberHandler handler = new NumberHandler();

  @Test
  void should_be_Fizz_if_it_is_divisible_by_three() {
    assertTrue(handler.isFizz(3));
  }

  @Test
  void should_not_be_Fizz_if_it_is_not_divisible_by_three() {
    assertFalse(handler.isFizz(2));
  }

  @Test
  void should_be_Buzz_if_it_is_divisible_by_five() {
    assertTrue(handler.isBuzz(5));
  }

  @Test
  void should_not_be_Buzz_if_it_is_not_divisible_by_five() {
    assertFalse(handler.isBuzz(2));
  }

  @Test
  void should_be_FizzBuzz_if_it_is_both_Fizz_and_Buzz() {
    assertTrue(handler.isFizzBuzz(15));
  }

  @Test
  void should_not_be_FizzBuzz_if_it_is_not_both_Fizz_and_Buzz() {
    assertFalse(handler.isFizzBuzz(5));
  }

  @Test
  void should_be_Fizz_if_it_contains_three() {
    assertTrue(handler.isFizz(13));
  }

  @Test
  void should_be_Buzz_if_it_contains_five() {
    assertTrue(handler.isBuzz(51));
  }
}