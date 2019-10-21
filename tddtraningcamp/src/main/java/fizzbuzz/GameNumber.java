package fizzbuzz;

public class GameNumber {
	private int number;

	public GameNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		String result = "";
		if (isRelatedTo(3)) {
			result += "fizz";
		}
		if (isRelatedTo(5)) {
			result += "buzz";
		}
		return result == "" ? String.valueOf(number) : result;
	}

	private boolean isRelatedTo(int i) {
		return number % i == 0 || String.valueOf(number).contains(String.valueOf(i));
	}
}
