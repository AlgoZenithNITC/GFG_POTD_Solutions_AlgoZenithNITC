class Solution {
  public:
    void setMatrixZeroes(vector<vector<int>> &mat) {
        // code here
        int c0 = 1;
        for(int i=0; i<mat.size(); ++i)
        {
            for(int j=0; j<mat[i].size(); ++j)
            {
                if(mat[i][j]==0)
                {
                    mat[i][0] = 0;
                    if(j==0)
                    {
                        c0 = 0;
                    }
                    else
                    {
                        mat[0][j] = 0;
                    }
                }
            }
        }
        for(int i=1; i<mat.size(); ++i)
        {
            for(int j=1; j<mat[i].size(); ++j)
            {
                if(mat[i][0]==0 || mat[0][j]==0)
                {
                    mat[i][j] = 0;
                }
            }
        }
        if(mat[0][0]==0)
        {
            for(int i=0; i<mat[0].size(); ++i)
            {
                mat[0][i] = 0;
            }
        }
        if(c0==0)
        {
            for(int j=0; j<mat.size(); ++j)
            {
                mat[j][0] = 0;
            }
        }
    }
};