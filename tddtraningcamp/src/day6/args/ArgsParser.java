package day6.args;

import java.util.HashMap;
import java.util.Map;

public class ArgsParser {
	private Map<String, String> map = new HashMap<>();

	public ArgsParser(String arguments) {
		if (arguments.length() == 0) {
			return;
		}
		String[] splits = arguments.split(" ");
		for (int i = 0; i < splits.length; i++) {
			String split = splits[i];
			String next = i < splits.length - 1 ? splits[i + 1] : "";
			if (Args.isFlag(split)) {
				String value = Args.isFlag(next) ? "" : next;
				map.put(split.substring(1), value);
			}
		}
	}

	public boolean getBool(String flag) {
		return map.containsKey(flag);
	}

	public String getString(String flag) {
		if (map.containsKey(flag)) {
			return map.get(flag);
		}
		return "";
	}

	public int getInt(String flag) {
		if (map.containsKey(flag)) {
			return Integer.valueOf(map.get(flag));
		}
		return 0;
	}

	public double getDouble(String flag) {
		if (map.containsKey(flag)) {
			return Double.valueOf(map.get(flag));
		}
		return 0.0;
	}
}
