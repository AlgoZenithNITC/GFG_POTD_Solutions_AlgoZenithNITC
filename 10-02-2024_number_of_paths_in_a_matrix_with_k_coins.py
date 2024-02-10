class Solution:
    def __init__(self):
        self.dp = [[[-1 for _ in range(101)] for _ in range(101)] for _ in range(101)]

    def helper(self, n, m, k, arr):
        if k < 0:
            return 0
        if m < 0 or n < 0:
            return 0
        if n == 0 and m == 0:
            return int(k == arr[n][m])
        if self.dp[n][m][k] != -1:
            return self.dp[n][m][k]
        left = self.helper(n, m - 1, k - arr[n][m], arr)
        up = self.helper(n - 1, m, k - arr[n][m], arr)
        self.dp[n][m][k] = left + up
        return self.dp[n][m][k]

    def number_of_path(self, n, k, arr):
        for i in range(n):
            for j in range(n):
                for l in range(k + 1):
                    self.dp[i][j][l] = -1
        self.helper(n - 1, n - 1, k, arr)
        return self.dp[n - 1][n - 1][k]

