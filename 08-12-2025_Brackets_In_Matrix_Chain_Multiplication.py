class Solution:
    def matrixChainOrder(self, arr):
        n = len(arr)
        dp = [[("", 0) for _ in range(n)] for _ in range(n)]

        for i in range(n):
            dp[i][i] = (chr(ord('A') + i), 0)

        for length in range(2, n):
            for i in range(n - length):
                j = i + length - 1
                min_cost = float('inf')
                best = ""

                for k in range(i + 1, j + 1):
                    cost = dp[i][k - 1][1] + dp[k][j][1] + arr[i] * arr[k] * arr[j + 1]
                    if cost < min_cost:
                        min_cost = cost
                        best = "(" + dp[i][k - 1][0] + dp[k][j][0] + ")"

                dp[i][j] = (best, min_cost)

        return dp[0][n - 2][0]
