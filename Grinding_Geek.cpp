class Solution{
    public:
    int max_courses(int n, int total, vector<int> &cost){
        vector<vector<int>> dp(n + 1, vector<int>(total + 1, -1));
        for(int i = n; i >= 0; i--){
            for(int j = 0; j <= total; j++){
                if(i == n or j == 0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i + 1][j]; //not take
                    if(j >= cost[i]){ //take
                        dp[i][j] = max(dp[i][j], 1 + dp[i + 1][j - cost[i] + (9*cost[i]/10)]);
                    }
                }
            }
        }
        return dp[0][total];
    }
};
