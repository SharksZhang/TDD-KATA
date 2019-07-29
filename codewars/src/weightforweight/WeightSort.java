package weightforweight;

import java.util.Arrays;

public class WeightSort {
    public static String orderWeight(String strng) {
        // your code
        String[] arr = strng.split(" ");
        Arrays.sort(arr, WeightSort::compare);
        return String.join(" ", arr);
    }


    private static int compare(String first, String second) {
        int firstSum = computeString(first);
        int secondSum = computeString(second);
        return firstSum != secondSum ? firstSum -secondSum : first.compareTo(second);
    }

    private static int computeString(String s) {
        return s.chars().map(c ->(Character.getNumericValue(c))).sum();
    }
}
