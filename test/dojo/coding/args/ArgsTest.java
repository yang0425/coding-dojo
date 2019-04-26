package dojo.coding.args;

import dojo.coding.args.exception.InvalidParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArgsTest {

  private Args args;

  @BeforeEach
  void setUp() {
    args = new Args("logging:l:bool,port:p:int,directory:d:string");
  }

  @ParameterizedTest
  @CsvSource({
      "'logging: false, port: 0, directory: ',",
      "'logging: true, port: 0, directory: ',-l",
      "'logging: false, port: 8080, directory: ',-p 8080",
      "'logging: false, port: -1, directory: ',-p -1",
      "'logging: false, port: 0, directory: /usr/logs',-d /usr/logs",
      "'logging: true, port: 8080, directory: /usr/logs',-d /usr/logs -l -p 8080",
  })
  void should_parse_commands(String expected, String command) {
    assertEquals(expected, args.parse(command));
  }

  @ParameterizedTest
  @CsvSource({
      "the flag 'l' should not has any parameters after it.,-l a"
  })
  void should_throw_invalid_parameter_exception(String expected, String command) {
    InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> args.parse(command));
    assertEquals(expected, exception.getMessage());
  }
}
