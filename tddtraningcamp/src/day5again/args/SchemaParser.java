package day5again.args;

import java.util.Arrays;
import java.util.HashMap;

public class SchemaParser {

	public static final String SCHEMA_SEPARATOR = ",";

	public static final String STRING_FLAG = "*";

	HashMap<String, String> schemaMap;

	public SchemaParser(String schemas) throws Exception {
		schemaMap = new HashMap<>();
		if (schemas.length() == 0) {
			return;
		}
		checkSchemas(schemas);
		Arrays.stream(schemas.split(SCHEMA_SEPARATOR)).
				forEach((x) -> schemaMap.put(x.substring(0, 1),x.substring(1)));
	}

	private void checkSchemas(String schemas) throws Exception {
		for (String schema : schemas.split(SCHEMA_SEPARATOR)) {
			if (!Character.isAlphabetic(schema.charAt(0))) {
				throw new Exception("schema type error");
			}

			if (schema.length() == 1) {
				return;
			}

			if (schema.length() == 2 && schema.substring(1).equals(STRING_FLAG)) {
				return;
			}

			if (schema.length() == 2 && schema.substring(1).equals("#")) {
				return;
			}

			if (schema.length() == 3 && schema.substring(1).equals("##")) {
				return;
			}
			throw new Exception("schema type error");
		}
	}

	public boolean isBool(String flag) {
		if (schemaMap.containsKey(flag)) {
			return true;
		}
		return false;
	}

	public boolean isString(String flag) {

		if(schemaMap.containsKey(flag) && schemaMap.get(flag).equals(STRING_FLAG)){
			return true;
		}
		return false;
	}

	public boolean isInteger(String flag) {
		if (schemaMap.containsKey(flag) && schemaMap.get(flag).equals("#")) {
			return true;
		}
		return false;
	}

	public boolean isDouble(String flag) {
		if (schemaMap.containsKey(flag) && schemaMap.get(flag).equals("##")) {
			return true;
		}

		return false;
	}
}
