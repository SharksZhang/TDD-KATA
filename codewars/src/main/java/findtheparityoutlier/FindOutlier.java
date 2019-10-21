package findtheparityoutlier;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class FindOutlier {
	static int find(int[] integers) {
		if (integers.length < 3) {
			return 0;
		}
		IntPredicate predicate = null;

		if (isEven(integers[0]) && isEven(integers[1])) {
			predicate = FindOutlier::isOdd;
		}
		if (isOdd(integers[0]) && isOdd(integers[1])) {
			predicate = FindOutlier::isEven;
		}
		if (isOdd(0) && isEven(1) || isEven(0) && isOdd(1)) {
			predicate = isEven(integers[2]) ? FindOutlier::isOdd : FindOutlier::isEven;
		}
		return Arrays.stream(integers).filter(predicate).findFirst().orElse(0);
	}

	static boolean isEven(int num) {
		return num % 2 == 0;
	}

	static boolean isOdd(int num) {
		return num % 2 != 0;
	}

}

