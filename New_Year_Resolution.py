from typing import List


class Solution:
    def isPossible(self, N : int, coins : List[int]) -> bool:
        total = sum(coins)
        possibility = [[False] * (total + 1) for _ in range(N + 1)]
        for i in range(N + 1):
            possibility[i][0] = True
        for i in range(1, total + 1):
            possibility[0][i] = False
        for i in range(1, N + 1):
            for j in range(1, total + 1):
                if j < coins[i - 1]:
                    possibility[i][j] = possibility[i - 1][j]
                if j >= coins[i - 1]:
                    possibility[i][j] = possibility[i - 1][j] or possibility[i - 1][j - coins[i - 1]]
        for i in range(1, total + 1):
            if (i % 20 == 0 or i % 24 == 0 or i == 2024) and possibility[N][i]:
                return True
        return False
