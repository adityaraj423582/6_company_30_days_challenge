package GoldmanSachs;

public class Minimum_Consecutive_Cards_to_PickUp {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        System.out.println(minimumConsecutiveCards(arr, k));
    }

    private static int minimumConsecutiveCards(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return k - max;
    }
}
