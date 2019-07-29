package day3.fizzbuzz;

public class FizzBuzz {

    public static final String FIZZ_RES = "Fizz";
    public static final String BUZZ_RES = "Buzz";
    public static final int FIZZ_NUM = 3;
    public static final int BUZZ_NUM = 5;

    public String play(int inPut) {
        String result = "";
        if (matchRulis(inPut, FIZZ_NUM)) {
             result += FIZZ_RES;
        }
        if (matchRulis(inPut, BUZZ_NUM)) {
            result += BUZZ_RES;
        }

        return result.isEmpty()?inPut + "" : result;
    }

    private boolean matchRulis(int inPut, int buzzNum) {
        return isDivisible(inPut, buzzNum) || isContains(inPut, buzzNum);
    }

    private boolean isContains(int inPut, int buzzNum) {
        return String.valueOf(inPut).contains(String.valueOf(buzzNum));
    }

    private boolean isDivisible(int inPut, int num) {
        return inPut % num == 0;
    }
}
