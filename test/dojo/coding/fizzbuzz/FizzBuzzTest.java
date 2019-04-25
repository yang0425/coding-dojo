package dojo.coding.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

  @ParameterizedTest
  @CsvSource({
      "1,1",
      "Fizz,3",
      "Buzz,5",
      "FizzBuzz,15",
      "Fizz,31",
      "Buzz,52"
  })
  void should_return_right_value(String expected, int number) {
    assertEquals(expected, FizzBuzz.of(number));
  }

}
