package simpleencryptionalternatingsplit;

import java.util.function.Predicate;

public class Kata {

    public static String encrypt(final String text, final int n) {
        if (n <= 0) {
            return text;
        }

        String result = text;
        for (int i = 0; i < n; i++) {
            result = singleEncrypt(result);
        }
        return result;
    }

    private static String singleEncrypt(String text) {
        return filter(text, (i) -> (i % 2 != 0)) + filter(text, (i) -> (i % 2 == 0));
    }

    private static String filter(String text, Predicate<Integer> p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (p.test(i)) {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }


    public static String decrypt(final String encryptedText, final int n) {
        if (n <= 0) {
            return encryptedText;
        }

        String result = encryptedText;
        for (int i = 0; i < n; i++) {
            result = singleDecrypt(result);
        }
        return result;
    }

    private static String singleDecrypt(String encryptedText) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = encryptedText.length() / 2;

        while (i < encryptedText.length() / 2 && j < encryptedText.length()) {
            sb.append(encryptedText.charAt(j++));
            sb.append(encryptedText.charAt(i++));
        }

        while (j < encryptedText.length()) {
            sb.append(encryptedText.charAt(j++));
        }
        return sb.toString();
    }
}
