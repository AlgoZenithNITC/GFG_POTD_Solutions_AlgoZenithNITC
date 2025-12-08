class Solution {
public:
    string matrixChainOrder(vector<int> &arr) {
        int n = arr.size();
        vector<vector<pair<string,int>>> dp(n, vector<pair<string,int>>(n, {"",0}));

        for(int i = 0; i < n; i++){
            dp[i][i] = {string(1,'A'+i),0};
        }

        for(int len = 2; len < n; len++){
            for(int i = 0; i < n-len; i++){
                int j = i+len-1;
                int cost = INT_MAX;
                string best;
                for(int k = i+1; k <= j; k++){
                    int curr = dp[i][k-1].second + dp[k][j].second + arr[i]*arr[k]*arr[j+1];
                    if(curr < cost){
                        cost = curr;
                        best = "(" + dp[i][k-1].first + dp[k][j].first + ")";
                    }
                }
                dp[i][j] = {best,cost};
            }
        }
        return dp[0][n-2].first;
    }
};
