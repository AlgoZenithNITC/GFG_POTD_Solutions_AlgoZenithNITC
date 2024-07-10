class Solution {
  public:
    int maxSquare(int n, int m, vector<vector<int>> mat) {
        vector<int> prev (m);
        vector<int> curr (m);
        int ans=0;
        for(int i=0;i<m;i++)
        {
            prev[i]=mat[0][i];
            ans=max(ans,prev[i]);
        }
        for(int i=1;i<n;i++)
        {
            curr[0]=mat[i][0];
            ans=max(ans,curr[0]);
            for(int j=1;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    curr[j]=0;
                    continue;
                }
                curr[j]=1+min(prev[j],min(curr[j-1],prev[j-1]));
                ans=max(ans,curr[j]);
            }
            prev=curr;
        }
        return ans;
    }
};
