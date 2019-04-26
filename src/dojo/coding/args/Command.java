package dojo.coding.args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Command {

  private Map<String, ArgItem> argItemMap;
  private List<String> args = new ArrayList<>();

  public Command(String value, Map<String, ArgItem> argItemMap) {
    this.argItemMap = argItemMap;
    if (null != value) {
      args.addAll(Arrays.asList(value.split(" ")));
    }
  }

  void calculate() {
    if (hasNext()) {
      argItemMap.get(consumeFlag()).setValue(this);
      calculate();
    }
  }

  private String consumeFlag() {
    return args.remove(0).replaceFirst("-", "");
  }

  String consumeValue() {
    return args.remove(0);
  }

  String getNextValue() {
    return args.get(0);
  }

  boolean isFlag(String flag) {
    return flag.startsWith("-") && argItemMap.containsKey(flag.substring(1));
  }

  boolean hasNext() {
    return args.size() > 0;
  }
}
