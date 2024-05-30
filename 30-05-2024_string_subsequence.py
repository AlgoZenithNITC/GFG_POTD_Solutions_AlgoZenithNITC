
class Solution:
    def countWays(self, s1: str, s2: str) -> int:
        MOD = 10**9 + 7

        def solve(i, j, s1, s2, memo):
            if j >= len(s2):
                return 1
            if i >= len(s1):
                return 0

            if memo[i][j] != -1:
                return memo[i][j]

            ans = solve(i + 1, j, s1, s2, memo) % MOD

            if s1[i] == s2[j]:
                ans = (ans + solve(i + 1, j + 1, s1, s2, memo)) % MOD

            memo[i][j] = ans % MOD
            return memo[i][j]

        memo = [[-1 for _ in range(len(s2))] for _ in range(len(s1))]
        return solve(0, 0, s1, s2, memo)


