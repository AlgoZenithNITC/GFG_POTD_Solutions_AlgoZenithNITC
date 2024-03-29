class Solution:
    def isEularCircuitExist(self, v, adj):
        deg = [0] * v
        for i in range(v):
            for it in adj[i]:
                deg[it] += 1
        for i in range(v):
            if deg[i] % 2 != 0:
                return False
        return True

