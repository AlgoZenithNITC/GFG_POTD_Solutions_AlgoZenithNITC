class Solution:
    def minSuperSeq(self, s1, s2):
        # code here
        dp=[[0]*(len(s2)+1) for x in range(len(s1)+1)]
        for i in range(1,len(s1)+1):
            for j in range(1,len(s2)+1):
                if (s1[i-1]==s2[j-1]):
                    dp[i][j]=dp[i-1][j-1]+1
                else:
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1])
        
       
        return len(s1)+len(s2)-dp[len(s1)][len(s2)]
