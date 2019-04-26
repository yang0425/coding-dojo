package dojo.coding.args;

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
    this.value = Integer.valueOf(command.consumeValue());
  }

  @Override
  public String toString() {
    return String.format("%s: %s", name, value);
  }
}
