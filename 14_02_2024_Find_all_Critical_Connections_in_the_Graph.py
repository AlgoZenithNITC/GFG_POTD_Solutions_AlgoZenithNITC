
class Solution:
    def criticalConnections(self, v, adj):
        # code here
        def dfs(u, parent, disc, low, bridges):
            nonlocal time
            disc[u] = low[u] = time
            time += 1
            for v in adj[u]:
                if disc[v] == -1:  # v is not visited
                    dfs(v, u, disc, low, bridges)
                    low[u] = min(low[u], low[v])
                    if low[v] > disc[u]:
                        bridges.append((min(u, v), max(u, v)))
                elif v != parent:  # v is visited and not parent
                    low[u] = min(low[u], disc[v])

        disc = [-1] * v
        low = [-1] * v
        time = 0
        bridges = []
        for i in range(v):
            if disc[i] == -1:
                dfs(i, -1, disc, low, bridges)
        return sorted(bridges)
