class Solution:
    def findWinner(self, n : int, x : int, y : int) -> int:
        # code here
        dp = [0] * (n+1)
        dp[0] = 0
        dp[1] = 1
        for i in range(2, n+1):
            if i - 1 >= 0 and not dp[i-1]:
                dp[i] = 1
            elif i - x >= 0 and not dp[i-x]:
                dp[i] = 1
            elif i - y >= 0 and not dp[i-y]:
                dp[i] = 1
            else:
                dp[i] = 0
            
        return dp[n]
