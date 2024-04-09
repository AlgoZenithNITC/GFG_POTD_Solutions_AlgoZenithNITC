class Solution:
    def minPoints(self, points, M, N):
        self.m = M
        self.n = N
        self.ans = float('-inf')
        vis = [[0] * self.m for _ in range(self.n)]
        self.solve(0, 0, points[0][0], points[0][0], points, vis)
        return max(1, -1 * self.ans + 1)

    def solve(self, i, j, currMin, currSum, arr, vis):
        if i == self.n - 1 and j == self.m - 1:
            self.ans = max(self.ans, currMin)
            return
        if i < 0 or j < 0 or i >= self.n or j >= self.m:
            return
        if i + 1 < self.n and vis[i + 1][j] == 0:
            vis[i + 1][j] = 1
            self.solve(i + 1, j, min(currMin, currSum + arr[i + 1][j]), currSum + arr[i + 1][j], arr, vis)
            vis[i + 1][j] = 0

        if j + 1 < self.m and vis[i][j + 1] == 0:
            vis[i][j + 1] = 1
            self.solve(i, j + 1, min(currMin, currSum + arr[i][j + 1]), currSum + arr[i][j + 1], arr, vis)
            vis[i][j + 1] = 0
