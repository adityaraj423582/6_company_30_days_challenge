package Microsoft;

public class Course_Schedule {
    public static void main(String[] args) {
        int n = 100;
        int m = 100;
        int k = 100;
        double[][][] dp = new double[n + 1][m + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    if (i == 1 && j == 1 && l == 1) {
                        dp[i][j][l] = 0;
                    } else {
                        dp[i][j][l] = 1 + i * dp[i - 1][j][l] + j * dp[i][j - 1][l] + l * dp[i][j][l - 1];
                        dp[i][j][l] /= (i + j + l - 1);
                    }
                }
            }
        }
        System.out.println(dp[n][m][k]);
    }
}
