class Solution:
    def palindromicPartition(self, str):
        n = len(str)
        dp = [[True for _ in range(n)] for _ in range(n)]
        for k in range(1, n):
            for i in range(n - k):
                j = i + k
                dp[i][j] = (str[i] == str[j] and dp[i + 1][j - 1])
        cuts = [n - 1 for _ in range(n + 1)]
        cuts[0] = -1
        for i in range(1, n + 1):
            for j in range(1, i + 1):
                if dp[j - 1][i - 1]:
                    cuts[i] = min(cuts[i], cuts[j - 1] + 1)
        return cuts[n]
