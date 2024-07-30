from typing import List

class Solution:

    def __init__(self):
        self.result = []
        self.visited = []

    def path(self, m: List[List[int]], x: int, y: int, dir: str, n: int):
        if x == n - 1 and y == n - 1:
            self.result.append(dir)
            return

        if m[x][y] == 0 or self.visited[x][y]:
            return

        self.visited[x][y] = True


        if x > 0:
            self.path(m, x - 1, y, dir + 'U', n)
        if y > 0:
            self.path(m, x, y - 1, dir + 'L', n)
        if x < n - 1:
            self.path(m, x + 1, y, dir + 'D', n)
        if y < n - 1:
            self.path(m, x, y + 1, dir + 'R', n)

        self.visited[x][y] = False

    def findPath(self, m: List[List[int]]) -> List[str]:
        n = len(m)
        self.visited = [[False for _ in range(n)] for _ in range(n)]
        self.result.clear()

        if m[0][0] == 0 or m[n - 1][n - 1] == 0:
            return self.result

        self.path(m, 0, 0, "", n)

        return self.result
