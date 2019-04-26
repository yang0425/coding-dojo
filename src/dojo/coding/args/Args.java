package dojo.coding.args;

import dojo.coding.args.exception.UnsupportedTypeException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class Args {

  private Map<String, ArgItem> argItemMap = new LinkedHashMap<>();

  public Args(String schema) {
    Arrays.stream(schema.split(",")).forEach(this::addArgItem);
  }

  String parse(String command) {
    new Command(command, argItemMap).calculate();
    return argItemMap.values().stream().map(ArgItem::toString).collect(joining(", "));
  }

  private void addArgItem(String itemSchema) {
    String[] items = itemSchema.split(":");
    String flag = items[1];
    String name = items[0];
    switch (items[2]) {
      case "int":
        argItemMap.put(flag, new IntArgItem(name, flag));
        break;
      case "string":
        argItemMap.put(flag, new StringArgItem(name, flag));
        break;
      case "bool":
        argItemMap.put(flag, new BooleanArgItem(name, flag));
        break;
      default:
        throw new UnsupportedTypeException();
    }
  }
}
