package GoldmanSachs;

public class Maximum_Points_in_an_Archery_Competition {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        System.out.println(maxPoints(arr, k));
    }

    private static int maxPoints(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int i = 0; i < k; i++) {
            for (int j = n - 1; j >= i; j--) {
                for (int l = i; l < j; l++) {
                    dp[j] = Math.max(dp[j], dp[l] + (sum[j] - sum[l]) * (j - l));
                }
            }
        }
        return dp[n - 1];
    }
}
