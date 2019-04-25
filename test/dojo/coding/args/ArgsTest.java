package dojo.coding.args;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArgsTest {

  private Args args;

  @BeforeEach
  void setUp() {
    args = new Args("logging:l:bool,port:p:int,directory:d:string");
  }

  @ParameterizedTest
  @CsvSource({
      "'logging: false, port: 0, directory: ',"
  })
  void should_parse_commands(String expected, String command) {
    assertEquals(expected, args.parse(command));
  }
}
