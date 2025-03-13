class Solution {
    public int knapsack(int W, int[] val, int[] wt) {
        int n = wt.length;
        int[][] dp = new int[W + 1][n + 1];

        for (int w = 1; w <= W; w++) {
            for (int i = 0; i < n; i++) {
                dp[w][i + 1] = dp[w][i];
                if (wt[i] <= w) {
                    dp[w][i + 1] = Math.max(dp[w][i + 1], dp[w - wt[i]][i] + val[i]);
                }
            }
        }
        return dp[W][n];
    }
