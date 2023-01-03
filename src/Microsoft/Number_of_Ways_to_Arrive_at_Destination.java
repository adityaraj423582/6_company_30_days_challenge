package Microsoft;

public class Number_of_Ways_to_Arrive_at_Destination {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        int start = 0;
        int end = 6;
        int maxTime = 7;
        System.out.println(countPaths(n, edges, start, end, maxTime));
    }

    public static int countPaths(int n, int[][] edges, int start, int end, int maxTime) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        int[][] dp = new int[n][maxTime + 1];
        dp[start][0] = 1;
        for (int t = 1; t <= maxTime; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) {
                        dp[i][t] += dp[j][t - 1];
                    }
                }
            }
        }
        return dp[end][maxTime];
    }

}
