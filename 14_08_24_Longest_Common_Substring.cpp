class Solution {
  public:
    int find(int n,int m,int &maxi,string &str1, string &str2,vector<vector<int>> &dp){
        if(n==0 || m==0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(str1[n-1]==str2[m-1]){
            dp[n][m] =1 + find(n-1, m-1,maxi, str1,str2,dp);
            maxi = max(maxi, dp[n][m]);
        } else {
            dp[n][m] = 0;
        }
        return dp[n][m];
    }
    int longestCommonSubstr(string str1, string str2) {
        // your code here
        int n=str1.size();
        int m=str2.size();
        vector<vector<int>> dp(n+1,vector<int> (m+1,-1));
        int maxi=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                find(i,j,maxi,str1,str2,dp);
            }
        }
        return maxi;
    }
};
