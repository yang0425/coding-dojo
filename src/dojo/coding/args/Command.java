package dojo.coding.args;

public class Command {

  private String value;

  public Command(String value) {
    this.value = value;
  }

  String getFlag() {
    char flag = this.value.charAt(1);
    consumeValue(2);
    return String.valueOf(flag);
  }

  String getValue() {
    consumeValue(1);
    int blankIndex = value.indexOf(" ");
    if (blankIndex == -1) {
      String result = value;
      consumeAllValue();
      return result;
    } else {
      String result = value.substring(0, blankIndex);
      consumeValue(blankIndex);
      return result;
    }
  }

  boolean hasNext() {
    return null != value && value.length() > 0;
  }

  private void consumeValue(int length) {
    this.value = value.substring(length);
  }

  private void consumeAllValue() {
    this.value = null;
  }
}
