package findtheuniquenumber;

import java.util.Arrays;

public class Kata {
    public static double findUniq(double arr[]) {
        // Do the magic
        double same = arr[0] == arr[1] ? arr[0]: arr[2];
        return  Arrays.stream(arr).filter((x)->(x != same)).findFirst().getAsDouble();
    }
}
