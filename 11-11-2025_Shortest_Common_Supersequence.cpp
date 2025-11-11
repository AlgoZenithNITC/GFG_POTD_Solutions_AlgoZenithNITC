class Solution {
  public:
    int minSuperSeq(string &s1, string &s2) {
        // code here
        vector <vector<int>>dp(s1.size()+1,vector<int>(s2.size()+1,0));
        for (int i=1;i<=(int)s1.size();i++)
        {   for (int j=1;j<=(int)s2.size();j++)
            {   if (s1[i-1]==s2[j-1])
                {   dp[i][j]=dp[i-1][j-1]+1;    }
                else
                {   dp[i][j]=max(dp[i-1][j],dp[i][j-1]);    }
            }
        }
        return s1.size()+s2.size()-dp[s1.size()][s2.size()];
    }
};
