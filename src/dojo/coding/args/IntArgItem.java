package dojo.coding.args;

public class IntArgItem implements ArgItem {

  private String name;
  private int value;

  IntArgItem(String name) {
    this.name = name;
  }

  @Override
  public void setValue(String value) {
    this.value = Integer.valueOf(value);
  }

  @Override
  public String toString() {
    return String.format("%s: %s", name, value);
  }
}