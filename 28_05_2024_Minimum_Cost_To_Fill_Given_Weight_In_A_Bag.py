
from typing import List


class Solution:
    def minimumCost(self, n : int, w : int, cost : List[int]) -> int:
        mx=100000000000
        dp=[[mx for i in range(w+1)]for i in range(n+1)]
        for i in range(n+1):
            dp[i][0]=0
        for i in range(1,n+1):
            for j in range(1,w+1):
                if(cost[i-1]!=-1 and j-i>=0):
                    dp[i][j]=min(dp[i-1][j],dp[i][j-i]+cost[i-1])
                else:
                    dp[i][j]=dp[i-1][j]
        if(dp[n][w]==mx):
            return -1
        return dp[n][w]
        
        

