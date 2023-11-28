class Solution:
    def sumOfDependencies(self, adj, V):
        return sum(map(len, adj))
