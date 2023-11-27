class Solution:
    def findparent(self, vertex, parent):
        if vertex == parent[vertex]:
            return vertex
        parent[vertex] = self.findparent(parent[vertex], parent)
        return parent[vertex]
	def detectCycle(self, n, adj):
		parent = [i for i in range(n)]
		depth = [1 for _ in range(n)]
		mp = {}
		for i in range(n):
		    for j in range(len(adj[i])):
		        a = i
		        b = adj[i][j]
                if (a, b) in mp or (b, a) in mp:
                   continue
                mp[(a, b)] = 1
                a_parent = self.findparent(a, parent)
                b_parent = self.findparent(b, parent)
                if a_parent != b_parent:
                    if depth[a_parent] > depth[b_parent]:
                       parent[b_parent] = a_parent
                       depth[a_parent] += depth[b_parent]
                    elif depth[a_parent] < depth[b_parent]:
                       parent[a_parent] = b_parent
                       depth[b_parent] += depth[a_parent]
                    else:
                       parent[a_parent] = b_parent
                       depth[b_parent] += depth[a_parent]
                else:
                    return 1
        return 0
