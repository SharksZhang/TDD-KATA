package simpleencryptionalternatingsplit;

import java.util.function.Predicate;

public class Kata {

    public static String encrypt(final String text, final int n) {
        // Your code here
//

        if (n <= 0) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getString(text, (i)->(i %2 != 0)));


        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) {
                sb.append(text.charAt(i));
            }
        }

        return sb.toString();
    }

    private static StringBuilder getString(String text, Predicate<Integer> p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (p.test(i)) {
                sb.append(text.charAt(i));
            }
        }
        return sb;
    }


    public static String decrypt(final String encryptedText, final int n) {
        // Your code here
        return null;
    }

}
