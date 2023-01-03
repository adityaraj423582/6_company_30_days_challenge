package Microsoft;

public class Longest_Happy_Prefix {
    public static void main(String[] args) {
        String s = "ababab";
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int j = dp[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = dp[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            dp[i] = j;
        }
        System.out.println(s.substring(0, dp[n - 1]));
    }
}
