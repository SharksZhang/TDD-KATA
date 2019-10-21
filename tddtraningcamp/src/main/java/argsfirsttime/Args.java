package argsfirsttime;

public class Args {
	private SchemaParser schemaParser;
	private ArgsParser arguments;

	public Args(String schemas, String arguments) throws Exception {
		this.schemaParser = new SchemaParser(schemas);
		checkArgumentsStr(arguments);
		this.arguments = new ArgsParser(arguments);
	}

	static boolean isFlag(String split) {
		return split.startsWith("-");
	}

	public boolean getBoolean(String flag) throws Exception {
		if (!schemaParser.isBool(flag)) {
			throw new Exception("flag is not bool type");
		}
		return arguments.getBool(flag);
	}

	public String getString(String flag) throws Exception {
		if (!schemaParser.isString(flag)) {
			throw new Exception("flag is not String type");
		}
		return arguments.getString(flag);
	}

	public int getInt(String flag) throws Exception {
		if(!schemaParser.isInt(flag)){
			throw new Exception("flag is not int type");
		}
		return arguments.getInt(flag);
	}

	public double getDouble(String flag) throws Exception {
		if (!schemaParser.isDouble(flag)) {
			throw new Exception("flag is not double");
		}
		return arguments.getDouble(flag);
	}

	private void checkArgumentsStr(String arguments) throws Exception {
		if (arguments.length() == 0) {
			return;
		}
		String[] splits = arguments.split(" ");
		for (int i = 0; i < splits.length; i++) {
			String arg = splits[i];
			if (i == 0 && !Args.isFlag(arg)) {
				throw new Exception("arg format error");
			}
			//
			if (Args.isFlag(arg)) {
				checkFlag(arg, i, splits);
			}
			else {
				if (i < splits.length - 1 && !Args.isFlag(splits[i + 1])) {
					throw new Exception("one flag has two value");
				}
			}
		}
	}
	private void checkFlag(String arg, int i, String[] splits) throws Exception {
		if (arg.length() != 2) {
			throw new Exception("flag format in arg error");
		}
		if (!Character.isAlphabetic(arg.charAt(1))) {
			throw new Exception("flag should be alphabetic");
		}
		if (!schemaParser.hasFlag(arg.substring(1))) {
			throw new Exception("flag not in schema");
		}
		if (schemaParser.isBool(arg.substring(1))) {
			if (i < splits.length - 1 && !Args.isFlag(splits[i + 1])) {
				throw new Exception("bool should not have value");
			}
		}
		else {
			if (i < splits.length - 1 && Args.isFlag(splits[i + 1]) || i == splits.length - 1) {
				throw new Exception("flag should have value");
			}
		}
	}
}

