class Solution:
    def dfs_util(self, i, adj, ans, visited):
        ans.append(i)
        visited[i] = True
        for z in adj[i]:
            if not visited[z]:
                self.dfs_util(z, adj, ans, visited)

    def dfs(self, adj):
        ans = []
        visited = {i: False for i in range(len(adj))}
        self.dfs_util(0, adj, ans, visited)
        return ans

# Driver code
if __name__ == "__main__":
    tc = int(input().strip())
    for _ in range(tc):
        V = int(input().strip())
        adj = []
        
        for _ in range(V):
            line = input().strip()
            if line:
                node = list(map(int, line.split()))
            else:
                node = []
            adj.append(node)
        
        obj = Solution()
        ans = obj.dfs(adj)
        print(" ".join(map(str, ans)))
