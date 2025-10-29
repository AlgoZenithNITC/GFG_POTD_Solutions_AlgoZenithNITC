from collections import deque

class Solution:
    def bfs(self, start, adj, V):
        dist = [-1] * V
        q = deque([start])
        dist[start] = 0
        farthest_node = start

        while q:
            node = q.popleft()
            for nbr in adj[node]:
                if dist[nbr] == -1:
                    dist[nbr] = dist[node] + 1
                    q.append(nbr)
                    if dist[nbr] > dist[farthest_node]:
                        farthest_node = nbr
        
        return farthest_node, dist[farthest_node]

    def diameter(self, V, edges):
        adj = [[] for _ in range(V)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        nodeA, _ = self.bfs(0, adj, V)
        _, diameter_value = self.bfs(nodeA, adj, V)
        
        return diameter_value
