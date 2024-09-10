class Solution:
    def dfs(self, node, graph, visited):
        visited[node] = 1
        for u in graph[node]:
            if not visited[u]:
                self.dfs(u, graph, visited)

    def isCircle(self, words):
        n = len(words)
        graph = [[] for _ in range(26)]
        transpose = [[] for _ in range(26)]

        for i in range(n):
            length = len(words[i]) - 1
            graph[ord(words[i][0]) - ord('a')].append(ord(words[i][length]) - ord('a'))
            transpose[ord(words[i][length]) - ord
