class Solution {
public:
    int knapsack(int W, vector<int>& val, vector<int>& wt) {
        int n = wt.size();
        vector<vector<int>> dp(W + 1, vector<int>(n + 1, 0));

        for (int w = 1; w <= W; w++) {
            for (int i = 0; i < n; i++) {
                dp[w][i + 1] = dp[w][i];
                if (wt[i] <= w) {
                    dp[w][i + 1] = max(dp[w][i + 1], dp[w - wt[i]][i] + val[i]);
                }
            }
        }
        return dp[W][n];
    }
};