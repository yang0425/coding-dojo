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
    calculateCommand(new Command(command));
    return argItemMap.values().stream().map(ArgItem::toString).collect(joining(", "));
  }

  private void calculateCommand(Command command) {
    if (command.hasNext()) {
      argItemMap.get(command.getFlag()).setValue(command);
      calculateCommand(command);
    }
  }

  private void addArgItem(String itemSchema) {
    String[] items = itemSchema.split(":");
    String flag = items[1];
    String name = items[0];
    switch (items[2]) {
      case "int":
        argItemMap.put(flag, new IntArgItem(name));
        break;
      case "string":
        argItemMap.put(flag, new StringArgItem(name));
        break;
      case "bool":
        argItemMap.put(flag, new BooleanArgItem(name));
        break;
      default:
        throw new UnsupportedTypeException();
    }
  }
}
