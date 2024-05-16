from typing import List

class Solution:
    def __init__(self):
        self.ans = 0
    
    def dfs(self, start, adj, visited):
        count = 0
        result = 0
        visited[start] = 1
        for neighbor in adj[start]:
            if not visited[neighbor]:
                result = self.dfs(neighbor, adj, visited)
                if result % 2 == 0:
                    self.ans += 1
                else:
                    count += result
        return count + 1

    def minimumEdgeRemove(self, n: int, edges: List[List[int]]) -> int:
        adj = [[] for _ in range(n)]
        visited = [0] * n

        for edge in edges:
            u, v = edge[0], edge[1]
            adj[u - 1].append(v - 1)
            adj[v - 1].append(u - 1)

        self.dfs(0, adj, visited)
        return self.ans
