package dojo.coding.args;

import dojo.coding.args.exception.InvalidParameterException;

public class IntArgItem implements ArgItem {

  private String name;
  private String flag;
  private int value;

  IntArgItem(String name, String flag) {
    this.name = name;
    this.flag = flag;
  }

  @Override
  public void setValue(Command command) {
    if (command.hasNext()) {
      try {
        this.value = Integer.valueOf(command.consumeValue());
      } catch (NumberFormatException e) {
        throw new InvalidParameterException(String.format("the flag '%s' should has a int parameter after it.", flag));
      }
    }
    throw new InvalidParameterException(String.format("the flag '%s' should has a int parameter after it.", flag));
  }

  @Override
  public String toString() {
    return String.format("%s: %s", name, value);
  }
}
