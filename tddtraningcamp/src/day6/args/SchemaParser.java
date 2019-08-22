package day6.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SchemaParser {
	Map<String, String> map = new HashMap<>();
	Set<String> schemaFlagSet = new HashSet<>
			(Arrays.asList("", "*", "#", "##"));

	public SchemaParser(String schemas) throws Exception {

		String[] s = schemas.split(",");
		for (String s1 : s) {
			if (s1.length() < 1) {
				throw new Exception("Schemas format error");
			}

			if (!Character.isAlphabetic(s1.charAt(0))) {
				throw new Exception("The first Character should be Alpha");
			}
			if (!schemaFlagSet.contains(s1.substring(1))) {
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
		if (hasFlag(flag) && map.get(flag).equals("*") ) {
			return true;
		}
		return false;
	}

	public boolean hasFlag(String flag) {
		return map.containsKey(flag);
	}

	public boolean isInt(String flag) {
		if (hasFlag(flag) && map.get(flag).equals("#") ) {
			return true;
		}
		return false;
	}

	public boolean isDouble(String flag) {
		if (hasFlag(flag) && map.get(flag).equals("##")) {
			return true;
		}
		return false;
	}
}
