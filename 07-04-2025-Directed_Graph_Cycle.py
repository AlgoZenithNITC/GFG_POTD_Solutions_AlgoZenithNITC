class Solution:
    def dfsCheck(self, node, visited, onpath, adj):
        visited[node] = 1
        onpath[node] = 1
        
        for neighbor in adj[node]:
            if not visited[neighbor]:
                if self.dfsCheck(neighbor, visited, onpath, adj):
                    return True
            elif onpath[neighbor]:
                return True
        
        onpath[node] = 0  # Backtrack
        return False

    def isCycle(self, V, edges):
        adj = [[] for _ in range(V)]
        
        for u, v in edges:
            adj[u].append(v)
        
        visited = [0] * V
        onpath = [0] * V
        
        for i in range(V):
            if not visited[i]:
                if self.dfsCheck(i, visited, onpath, adj):
                    return True
        return False
