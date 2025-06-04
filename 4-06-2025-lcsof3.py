class Solution:
    def lcsOf3(self, s1: str, s2: str, s3: str) -> int:
        n1, n2, n3 = len(s1), len(s2), len(s3)
        dp = [[[-1 for _ in range(n3)] for _ in range(n2)] for _ in range(n1)]
        return self.lc(s1, s2, s3, 0, 0, 0, dp)

    def lc(self, s1: str, s2: str, s3: str, n1: int, n2: int, n3: int, dp: list) -> int:
        if n1 >= len(s1) or n2 >= len(s2) or n3 >= len(s3):
            return 0

        if dp[n1][n2][n3] != -1:
            return dp[n1][n2][n3]

        if s1[n1] == s2[n2] == s3[n3]:
            dp[n1][n2][n3] = 1 + self.lc(s1, s2, s3, n1 + 1, n2 + 1, n3 + 1, dp)
            return dp[n1][n2][n3]

        dp[n1][n2][n3] = max(
            self.lc(s1, s2, s3, n1 + 1, n2, n3, dp),
            self.lc(s1, s2, s3, n1, n2 + 1, n3, dp),
            self.lc(s1, s2, s3, n1, n2, n3 + 1, dp)
        )
        return dp[n1][n2][n3]


