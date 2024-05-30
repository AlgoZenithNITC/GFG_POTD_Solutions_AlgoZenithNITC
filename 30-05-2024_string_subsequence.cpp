
class Solution {
  public:
  
    int m = 1e9+7;
    
    int solve(int i , int j , string &s1 , string &s2 , vector<vector<int>> &memo){
        
        if(j>=s2.size()) return 1;
        if(i>=s1.size()) return 0;
        
        if(memo[i][j]!=-1) return memo[i][j];
        
        int ans = solve(i+1,j,s1,s2,memo)%m;
        
        if(s1[i]==s2[j]){
            ans+=solve(i+1,j+1,s1,s2,memo)%m;
        }
        
        return memo[i][j]=ans%m ;
    }
   
    int countWays(string s1, string s2) {
        // code here
        vector<vector<int>> memo(s1.size(),vector<int>(s2.size(),-1));
        return solve(0,0,s1,s2,memo);
    }
};
