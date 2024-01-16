class Solution{
public:
    int numberSequence(int m, int n){
        vector<vector<int>> dp(m + 1, vector<int>(n + 1));
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == 0 or j == 0 or i < j){
                    dp[i][j] = 0;
                }
                else if(j == 1){
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i/2][j - 1];
                }
            }
        }
        return dp[m][n];
    }
};
