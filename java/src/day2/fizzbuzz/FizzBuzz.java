package day2.fizzbuzz;

public class FizzBuzz {

    public static final int FIZZ_NUM = 3;
    public static final String FIZZ_RES = "Fizz";
    public static final int BUZZ_NUM = 5;
    public static final String BUZZ_RES = "Buzz";

    public String play(int inPut) {
        String result = "";
        if (matchRules(inPut, FIZZ_NUM)) {
            result += FIZZ_RES;
        }
        if (matchRules(inPut, BUZZ_NUM)) {
            result += BUZZ_RES;
        }
        return result.isEmpty() ? inPut + "" : result;
    }

    private boolean matchRules(int inPut, int fizzNum) {
        return isDivisible(inPut, fizzNum) || isContains(inPut, String.valueOf(fizzNum));
    }

    private boolean isContains(int inPut, String s) {
        return String.valueOf(inPut).contains(s);
    }
    private boolean isDivisible(int inPut, int buzzNum) {
        return inPut % buzzNum == 0;
    }

}
