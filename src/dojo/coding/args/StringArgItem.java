package dojo.coding.args;

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
    this.value = command.consumeValue();
  }

  @Override
  public String toString() {
    return String.format("%s: %s", name, value);
  }
}
