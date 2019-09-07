class Solution {
    int n, k;

    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs == null) {
            return 0;
        }
        n = costs.length;
        k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = min(dp, j, i - 1) + costs[i][j];
            }
        }
        int min = dp[n - 1][0];
        for (int i = 1; i < k; i++) {
            if (min > dp[n - 1][i]) {
                min = dp[n - 1][i];
            }
        }
        return min;
    }

    private int min(int[][] dp, int j, int i) {
        int min;
        if (j == 0) {
            min = dp[i][1];
            for (int col = 2; col < k; col++) {
                if (dp[i][col] < min) {
                    min = dp[i][col];
                }
            }
        } else {
            min = dp[i][0];
            for (int col = 1; col < k; col++) {
                if (col == j) {
                    continue;
                }
                if (dp[i][col] < min) {
                    min = dp[i][col];
                }
            }
        }
        return min;
    }
}