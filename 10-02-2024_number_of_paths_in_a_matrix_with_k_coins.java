public class Solution {
    private long[][][] dp = new long[101][101][101];

    private long helper(int n, int m, int k, int[][] arr) {
        if (k < 0)
            return 0;
        if (m < 0 || n < 0)
            return 0;
        if (n == 0 && m == 0)
            return dp[n][m][k] = (k == arr[n][m] ? 1 : 0);
        if (dp[n][m][k] != -1)
            return dp[n][m][k];
        long left = helper(n, m - 1, k - arr[n][m], arr);
        long up = helper(n - 1, m, k - arr[n][m], arr);
        return dp[n][m][k] = left + up;
    }

    public long numberOfPath(int n, int k, int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        helper(n - 1, n - 1, k, arr);
        return dp[n - 1][n - 1][k];
    }
};

