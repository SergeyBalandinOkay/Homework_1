package utils;

import java.security.SecureRandom;

public class RandomUtils {
    public static String getRandomString(int lenghth) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < lenghth; i++)
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));


        return result.toString();

    }
}
