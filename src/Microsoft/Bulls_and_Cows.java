package Microsoft;

import java.util.*;

public class Bulls_and_Cows {
public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bulls++;
            } else {
                if (count[s] < 0) cows++;
                if (count[g] > 0) cows++;
                count[s]++;
                count[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

}
