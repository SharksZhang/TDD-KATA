package day1.fizzbuzz;

public class FizzBuzz {

    public static final int FIZZ_NUM = 3;
    public static final String FIZZ_STR = "3";
    public static final int BUZZ_NUM = 5;
    public static final String BUZZ_STR = "5";
    public static final String FIZZ_RESULT = "Fizz";
    public static final String BUZZ_RESULT = "Buzz";

    public String play(int i) {
        if (isFizzBuzz(i)) {
            return FIZZ_RESULT + BUZZ_RESULT;
        }

        if (filter(i, FIZZ_NUM, FIZZ_STR)) {
            return FIZZ_RESULT;
        }

        if (filter(i, BUZZ_NUM, BUZZ_STR)) {
            return BUZZ_RESULT;
        }
        return "" + i;
    }

    private boolean filter(int i, int diverNum, String containsStr) {
        return isDivisible(i, diverNum) || isContains(i, containsStr);
    }

    private boolean isContains(int i, String containsStr) {
        return new Integer(i).toString().contains(containsStr);
    }

    private boolean isDivisible(int i, int diverNum) {
        return i % diverNum == 0;
    }

    private boolean isFizzBuzz(int i) {
        return isDivisible(i, FIZZ_NUM) && isDivisible(i, BUZZ_NUM);
    }
}
