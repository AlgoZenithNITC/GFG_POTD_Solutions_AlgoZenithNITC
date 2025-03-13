class Solution:
    def knapsack(self, W, val, wt):
        # code here
         # code here
        n = len(wt)
        dp = [[0]*(n+1) for _ in range(W+1)]
        # dp[i][j] = max(dp[i][j], dp[i-wt[j]][j-1]+)
        for w in range(1, W+1):
            for i in range(n):
                dp[w][i+1] = dp[w][i]
                if wt[i] <= w:
                    dp[w][i+1] = max(dp[w][i+1], dp[w-wt[i]][i]+val[i])
        return dp[-1][-1]

