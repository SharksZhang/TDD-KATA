package day5again.args;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.function.Executable;

public class ArgsParser {
	Set<String> args;

	public ArgsParser(String arguments) throws Exception {
		args = new HashSet();
		if (arguments.length() == 0) {
			return;
		}
		checkArguments(arguments);
		Arrays.stream(arguments.split(" ")).map((x) -> (x.substring(1)))
				.forEach(args::add);
	}

	private void checkArguments(String arguments) throws Exception {
//		for (String argument : arguments.split(" ")) {
//
//			if(argument.length() != 2){
//				throw new Exception("arguments format Exception");
//			}
//
//			if(!Character.isAlphabetic(argument.charAt(1))){
//				throw new Exception("arguments format Exception");
//			}
//
//			if(argument.charAt(0) != '-'){
//				throw new Exception("arguments format Exception");
//			}
//		}

		for (String argument : arguments.split(" ")) {

			if(argument.length() != 2){
				throw new Exception("arguments format Exception");
			}

			if(!Character.isAlphabetic(argument.charAt(1))){
				throw new Exception("arguments format Exception");
			}

			if(argument.charAt(0) != '-'){
				throw new Exception("arguments format Exception");
			}
		}

	}

	public boolean get(String flag) {
		return args.contains(flag);
	}
}
