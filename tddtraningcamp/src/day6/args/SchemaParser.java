package day6.args;

import java.util.HashMap;
import java.util.Map;

public class SchemaParser {
	Map<String, String> map = new HashMap<>();

	public SchemaParser(String schemas) throws Exception {

		String[] s = schemas.split(",");
		for (String s1 : s) {
			if (s1.length() < 1) {
				throw new Exception("Schemas format error");
			}

			if (!Character.isAlphabetic(s1.charAt(0))) {
				throw new Exception("The first Character should be Alpha");
			}
			if (s1.substring(1).equals("")) {
			}
			else if (s1.substring(1).equals("*")) {

			}
			else {
				throw new Exception("Schemas format error");
			}
			map.put(s1.substring(0, 1), s1.substring(1));
		}
	}

	public boolean isBool(String flag) {
		if (map.containsKey(flag) && map.get(flag).equals("")) {
			return true;
		}
		return false;
	}

	public boolean isString(String flag) {
		if (!map.containsKey(flag) && map.get(flag) == "*") {
			return false;
		}
		if (!map.get(flag).equals("*")) {
			return false;
		}
		return true;
	}

	public boolean hasFlag(String flag) {
		return map.containsKey(flag);
	}
}
