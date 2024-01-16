class Solution:
 def numberSequence(self, m, n):
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 or j == 0 or i < j:
                dp[i][j] = 0
            elif j == 1:
                dp[i][j] = i
            else:
                dp[i][j] = dp[i - 1][j] + dp[i // 2][j - 1]
    return dp[m][n]
