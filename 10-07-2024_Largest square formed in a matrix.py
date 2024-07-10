class Solution:
    def maxSquare(self, n: int, m: int, mat: List[List[int]]) -> int:
        prev = [0] * m
        curr = [0] * m
        ans = 0

        for i in range(m):
            prev[i] = mat[0][i]
            ans = max(ans, prev[i])

        for i in range(1, n):
            curr[0] = mat[i][0]
            ans = max(ans, curr[0])
            for j in range(1, m):
                if mat[i][j] == 0:
                    curr[j] = 0
                    continue
                curr[j] = 1 + min(prev[j], min(curr[j - 1], prev[j - 1]))
                ans = max(ans, curr[j])
            prev = curr[:]

        return ans
