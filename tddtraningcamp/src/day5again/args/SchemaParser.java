package day5again.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SchemaParser {
	HashMap<String, String> schemaMap;

	public SchemaParser(String schemas) throws Exception {
		schemaMap = new HashMap<>();
		if (schemas.length() == 0) {
			return;
		}
		for (String schema : schemas.split(",")) {
			if (schema.length() != 1) {
				throw new Exception("schema length Error");
			}

			if (!Character.isAlphabetic(schema.charAt(0))) {
				throw new Exception("schema type error");
			}
		}
		Arrays.stream(schemas.split(",")).
				forEach((x) -> schemaMap.put(x, ""));
	}

	public boolean isBool(String flag) {
		if (schemaMap.containsKey(flag)) {
			return true;
		}
		return false;
	}

}
