
class Solution {
  public:
    int solve(int i,int w,vector<int> &cost,vector<vector<int>> &dp){
        if(w==0)
            return 0;
        if(i==cost.size())
            return (2e+7)+1;
        if(dp[i][w]!=-2)
            return dp[i][w];
        if(cost[i]==-1 || w<i+1)
            return dp[i][w]=solve(i+1,w,cost,dp);
        return dp[i][w]=min(solve(i+1,w,cost,dp),cost[i]+solve(i,w-(i+1),cost,dp));
        
    }
    int minimumCost(int n, int w, vector<int> &cost) {
        // code here
        vector<vector<int>> dp(n,vector<int>(w+1,-2));
        int ans=solve(0,w,cost,dp);
        return ans>(2e+7)?-1:ans;
    }
};
