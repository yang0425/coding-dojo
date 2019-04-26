package dojo.coding.args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {

  private List<String> args = new ArrayList<>();

  public Command(String value) {
    if (null != value) {
      args.addAll(Arrays.asList(value.split(" ")));
    }
  }

  String getFlag() {
    return args.remove(0).replaceFirst("-", "");
  }

  String getValue() {
    return args.remove(0);
  }

  boolean hasNext() {
    return args.size() > 0;
  }

}
