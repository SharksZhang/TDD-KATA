package findtheoddint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static java.util.Arrays.*;

public class FindOdd {
    public static int findIt(int[] a) {

        HashMap<Integer, Integer> countMap = new HashMap<>();
        Arrays.stream(a).reduce(0, (x, y) -> x ^ y );
        int result = 0;
        for (int i : a) {
            result^=i;
        }
        return result;
    }
}
