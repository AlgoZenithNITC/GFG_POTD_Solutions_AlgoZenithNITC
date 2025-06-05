class Solution:

    def countPaths(self, edges, V, src, dest):

        # to make graph
        graph = [[] for _ in range(V)]
        indegree = [0] * V

        # add edges and calculate in-degree
        for u, w in edges:
            graph[u].append(w)
            indegree[w] += 1

        # to make topological sorting
        q = deque()

        # insert all vertices which don't have any parent
        for i in range(V):
            if indegree[i] == 0:
                q.append(i)

        topo = []

        # using kahn's algorithm for topological sorting
        while q:
            node = q.popleft()
            topo.append(node)
            for nei in graph[node]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    q.append(nei)

        # to store number of ways
        dp = [0] * V
        dp[dest] = 1

        # traverse in reverse topological order
        for node in reversed(topo):
            for nei in graph[node]:
                dp[node] += dp[nei]

        return dp[src]