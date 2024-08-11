# Import necessary modules
from typing import List


# Class to implement the solution
class Solution:

    def __init__(self):
        self.result = []
        self.visited = []

    def path(self, m: List[List[int]], x: int, y: int, dir: str, n: int):
        # If the current cell is the destination, add the direction to the result list
        if x == n - 1 and y == n - 1:
            self.result.append(dir)
            return

        # If the current cell is blocked or already visited, return
        if m[x][y] == 0 or self.visited[x][y]:
            return

        # DFS traversal
        # Marking the current cell as visited
        self.visited[x][y] = True

        # Recursively calling the path function for the adjacent cells in all possible directions
        if x > 0:
            self.path(m, x - 1, y, dir + 'U', n)
        if y > 0:
            self.path(m, x, y - 1, dir + 'L', n)
        if x < n - 1:
            self.path(m, x + 1, y, dir + 'D', n)
        if y < n - 1:
            self.path(m, x, y + 1, dir + 'R', n)

        # Marking the current cell as not visited
        self.visited[x][y] = False

    # Function to find all possible paths
    def findPath(self, m: List[List[int]]) -> List[str]:
        n = len(m)
        # Resetting the visited cells and result list
        self.visited = [[False for _ in range(n)] for _ in range(n)]
        self.result.clear()

        # If the source or destination cell is blocked, return empty result list
        if m[0][0] == 0 or m[n - 1][n - 1] == 0:
            return self.result

        # Finding all possible paths
        self.path(m, 0, 0, "", n)

        # Returning the result list
        return self.result
