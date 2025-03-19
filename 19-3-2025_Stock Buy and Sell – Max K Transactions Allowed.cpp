class Solution {
    public:
      int solve(vector<int>& prices, int k,int i,bool canBuy,vector<vector<vector<int>>>&dp){
          //base case
          if(i==prices.size() || k==0 ) return 0;
          // recursive case
          if(dp[i][k][canBuy] != -1) return dp[i][k][canBuy];
          int involve =0, ignore=0;
          if(canBuy==true){
              involve=-prices[i] + solve(prices,k,i+1,false,dp);
              ignore=solve(prices,k,i+1,true,dp);
          }
          else{
              involve=prices[i] + solve(prices,k-1,i+1,true,dp);
              ignore=solve(prices,k,i+1,false,dp);
          }
          return dp[i][k][canBuy]= max(involve,ignore);
      }
      int maxProfit(vector<int>& prices, int k) {
          //CodeGenius
          int n=prices.size();
          vector<vector<vector<int>>>dp(n,vector<vector<int>>(k+1,vector<int>(2,-1)));
          return solve(prices,k,0,true,dp);
          
      }
  };