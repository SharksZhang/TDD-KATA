package day5again.args;

import java.util.HashMap;
import java.util.Map;

public class ArgsParser {

	public static final String ARG_SEPARATOR = " ";

	Map<String, String> args;

	public ArgsParser(String arguments) throws Exception {
		args = new HashMap<>();
		if (arguments.length() == 0) {
			return;
		}
		parser(arguments);
	}

	private void parser(String arguments) throws Exception {
		String[] argumentsArr = arguments.split(ARG_SEPARATOR);
		for (int i = 0; i < argumentsArr.length; i++) {
			if(i == 0 && !isFlag(argumentsArr[i])){
				throw new Exception("argument");
			}
			String argument = argumentsArr[i];
			if (!isFlag(argumentsArr[i])) {
				continue;
			}
			checkFlag(argument);
			if (isNotLastAndNextNotFlag(argumentsArr, i)) {
				args.put(argument.substring(1), argumentsArr[i + 1]);
			}
			else {
				args.put(argument.substring(1), "");
			}

		}
	}

	private boolean isNotLastAndNextNotFlag(String[] argumentsArr, int i) {
		return !isLastArgument(argumentsArr, i) && !isFlag(argumentsArr[i + 1]);
	}

	private boolean isLastArgument(String[] argumentsArr, int i2) {
		return i2 == argumentsArr.length - 1;
	}


	private void checkFlag(String argument) throws Exception {
		if (!isFlag(argument)) {
			return;
		}
		if (argument.length() != 2) {
			throw new Exception("arguments format Exception");

		}
		if (!Character.isAlphabetic(argument.charAt(1))) {
			throw new Exception("arguments format Exception");
		}
	}

	private boolean isFlag(String argument) {
		return argument.startsWith("-");
	}

	public boolean get(String flag) {
		return args.containsKey(flag);
	}

	public String getString(String flag) {
		if(!args.containsKey(flag)){
			return "";
		}

		return args.get(flag);
	}

	public int getInteger(String flag) {
		if(!args.containsKey(flag)){
			return 0;
		}
		return Integer.valueOf(args.get(flag));
	}

	public double getDouble(String flag) {
		if(!args.containsKey(flag)){
			return 0.0;
		}
		return Double.valueOf(args.get(flag));
	}
}
