class solution{
public:
  long long dp[101][101][101];
  long long helper(int n , int m ,int k , vector<vector<int>> &arr)
  {
      if(k<0)
          return 0;
      if(m<0||n<0)
          return 0;
      if(n==0&&m==0)
          return dp[n][m][k]=(k==arr[n][m]);
            
      if(dp[n][m][k]!=-1)
          return dp[n][m][k];
            
      long long left = helper(n,m-1,k-arr[n][m],arr);
      long long up = helper(n-1,m,k-arr[n][m],arr);
        
      return dp[n][m][k] = left + up;
  }

  long long numberOfPath(int n, int k, vector<vector<int>> &arr){
    
      for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int l=0;l<=k;l++)
                {
                    dp[i][j][l]=-1;
                }
            }
        }
        
        helper(n-1,n-1,k,arr);
        
        return dp[n-1][n-1][k];
  } 
};
