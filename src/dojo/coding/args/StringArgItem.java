package dojo.coding.args;

import dojo.coding.args.exception.InvalidParameterException;

public class StringArgItem implements ArgItem {

  private String name;
  private String flag;
  private String value = "";

  StringArgItem(String name, String flag) {
    this.name = name;
    this.flag = flag;
  }

  @Override
  public void setValue(Command command) {
    if (command.hasNext()) {
      this.value = command.consumeValue();
    }
    throw new InvalidParameterException(String.format("the flag '%s' should has a string parameter after it.", flag));
  }

  @Override
  public String toString() {
    return String.format("%s: %s", name, value);
  }
}
