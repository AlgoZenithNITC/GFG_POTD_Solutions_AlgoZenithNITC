class Solution {
    public:
    long long countWays(int n) {
        vector<long long>dp(n + 1);
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-2] + 1;
        }
        return dp[n];
    }
};
