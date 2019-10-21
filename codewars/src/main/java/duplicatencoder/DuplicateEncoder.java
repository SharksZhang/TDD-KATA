package duplicatencoder;

import java.util.stream.Collectors;

public class DuplicateEncoder {
	static String encode(String word) {
		return  word.toLowerCase().chars().
				mapToObj((c) -> ((char)c))
				.map((c) -> (word.toLowerCase().indexOf(c) == word.toLowerCase().lastIndexOf(c) ? "(":")" ))
				.collect(Collectors.joining());

		}


}

