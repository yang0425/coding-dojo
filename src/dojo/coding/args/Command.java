package dojo.coding.args;

import dojo.coding.args.exception.InvalidCommandException;
import dojo.coding.args.exception.InvalidFlagException;
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
      if (!value.startsWith("-")) {
        throw new InvalidCommandException("command must start with -{flag}");
      }
      args.addAll(Arrays.asList(value.split(" ")));
    }
  }

  void calculate() {
    if (hasNext()) {
      String flag = consumeFlag();
      if (!argItemMap.containsKey(flag)) {
        throw new InvalidFlagException(String.format("the flag '%s' is not supported.", flag));
      }
      argItemMap.get(flag).setValue(this);
      calculate();
    }
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

  private String consumeFlag() {
    return args.remove(0).replaceFirst("-", "");
  }
}
