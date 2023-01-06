package GoldmanSachs;

public class IPO {
    public static void main(String[] args) {
        int[] cost = {1, 2, 3, 4, 5};
        int[] profit = {3, 4, 5, 6, 7};
        int k = 2;
        int m = 10;
        System.out.println(maxProfit(cost, profit, k, m));
    }

    private static int maxProfit(int[] cost, int[] profit, int k, int m) {
        int n = cost.length;
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            int max = -cost[0];
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], profit[j - 1] + max);
                max = Math.max(max, dp[i - 1][j] - cost[j - 1]);
            }
        }
        return dp[k][n];
    }
}
