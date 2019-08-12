package duplicatencoder;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {
	static String encode(String word) {
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			char c = Character.toLowerCase(word.charAt(i));
			if (!map.containsKey(c)) {
				map.put(c, 1);
			}
			else {
				map.put(c, map.get(c) + 1);
			}
		}

		for (int i = 0; i < word.length(); i++) {
			char c = Character.toLowerCase(word.charAt(i));
			if (map.get(c) > 1) {
				sb.append(")");
			}
			else {
				sb.append("(");
			}

		}

		return sb.toString();
	}
}

