package dojo.coding.args;

public class BooleanArgItem implements ArgItem {

  private String name;
  private boolean value;

  BooleanArgItem(String name) {
    this.name = name;
  }

  @Override
  public void setValue(Command command) {
    this.value = true;
  }

  @Override
  public String toString() {
    return String.format("%s: %s", name, value);
  }
}
