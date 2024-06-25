class Solution:
    def rotateMatrix(self, k: int, mat: List[List[int]]) -> List[List[int]]:
        n, m = len(mat), len(mat[0])
        ans = [[0] * m for _ in range(n)]
        k %= m
        if k == 0:
            return mat
        for i in range(n):
            x = 0
            for j in range(k, m):
                ans[i][x] = mat[i][j]
                x += 1
            for j in range(k):
                ans[i][x] = mat[i][j]
                x += 1
        return ans

