package fizzbuzz;

import static java.lang.String.*;

public class GameNumber {
	private int number;

	public GameNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		String res = "";
		if (isRelatedTo(3)) {
			res +=  "fizz";
		}
		if (isRelatedTo(5)) {
			res +=  "buzz";
		}

		return res.isEmpty() ? valueOf(number) : res;
	}

	private boolean isRelatedTo(int i) {
		return number % i == 0 || valueOf(number).contains(valueOf(i));
	}
}
