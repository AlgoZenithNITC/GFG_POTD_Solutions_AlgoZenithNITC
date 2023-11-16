class Solution:
    def dfs(self, k, prev, seen, edges):
        for i in range(k):
            cur = prev
            cur += str(i)
            if cur not in seen:
                seen.add(cur)
                Solution().dfs(k, cur[1:], seen, edges)
                edges.append(i)

    def findString(self, n, k):
        seen = set()
        startingNode = '0' * (n-1)
        edges = []
        Solution().dfs(k, startingNode, seen, edges)
        ret = ''
        l = k ** n
        for i in range(l):
            ret += str(edges[i])
        ret += startingNode
        return ret
