package dojo.coding.args;

public class StringArgItem implements ArgItem {

  private String name;
  private String value = "";

  StringArgItem(String name) {
    this.name = name;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("%s: %s", name, value);
  }
}
