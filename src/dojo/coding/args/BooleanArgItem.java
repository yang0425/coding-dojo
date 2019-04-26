package dojo.coding.args;

import dojo.coding.args.exception.InvalidParameterException;

public class BooleanArgItem implements ArgItem {

  private String name;
  private String flag;
  private boolean value;

  BooleanArgItem(String name, String flag) {
    this.name = name;
    this.flag = flag;
  }

  @Override
  public void setValue(Command command) {
    if (command.hasNext() && !command.isFlag(command.getNextValue())) {
      throw new InvalidParameterException(String.format("the flag '%s' should not has any parameters after it.", flag));
    }
    this.value = true;
  }

  @Override
  public String toString() {
    return String.format("%s: %s", name, value);
  }
}
