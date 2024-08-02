class Solution {
  public:
  
    int solve(int i , int j , string s1 , string s2 ,vector<vector<int>> &memo){
        
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(memo[i][j]!=-1) return memo[i][j];
        
        if(s1[i]==s2[j]) return 0+solve(i-1,j-1,s1,s2,memo);
        
        int a = 1 + solve(i-1,j,s1,s2,memo); // remove
        int b = 1 + solve(i,j-1,s1,s2,memo); // insert
        int c = 1 + solve(i-1,j-1,s1,s2,memo); // replace 
            
        return memo[i][j]=min(a,min(b,c));
        
    }
  
    int editDistance(string str1, string str2) {
        // Code here
        int n = str1.size(),m=str2.size();
        
        vector<vector<int>> memo(n+1,vector<int>(m+1,-1));
        
        return solve(n-1,m-1,str1,str2,memo);
    }
};
