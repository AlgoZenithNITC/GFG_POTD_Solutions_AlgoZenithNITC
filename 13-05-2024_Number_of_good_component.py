
from typing import List

class Solution:
    def dfs(self, adj: List[List[int]], i: int, visited: List[bool]) -> None:
        visited[i] = True
        self.v_cnt += 1
        self.e_cnt += len(adj[i])

        for next_node in adj[i]:
            if not visited[next_node]:
                self.dfs(adj, next_node, visited)

    def findNumberOfGoodComponent(self, e: int, v: int, edges: List[List[int]]) -> int:
        visited = [False] * (v + 1)
        adj = [[] for _ in range(v + 1)]

        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])

        ans = 0

        for i in range(1, v + 1):
            self.v_cnt = 0
            self.e_cnt = 0
            if not visited[i]:
                visited[i] = True
                self.dfs(adj, i, visited)

                if self.e_cnt == self.v_cnt * (self.v_cnt - 1):
                    ans += 1

        return ans


