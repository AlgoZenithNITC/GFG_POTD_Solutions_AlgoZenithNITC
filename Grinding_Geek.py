from typing import List


class Solution:
  def max_courses(self, n : int, total : int, cost : List[int]) -> int:
    dp = [[-1] * (total + 1) for _ in range(n + 1)]
    for i in range(n, -1, -1):
        for j in range(total + 1):
            if i == n or j == 0:
                dp[i][j] = 0
            else:
                dp[i][j] = dp[i + 1][j]
                if j >= cost[i]:
                    dp[i][j] = max(dp[i][j], 1 + dp[i + 1][j - cost[i] + (9 * cost[i] // 10)])
    return dp[0][total]
