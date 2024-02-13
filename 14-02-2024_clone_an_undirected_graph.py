
class Solution():
    def cloneGraph(self, node):
        #your code goes here
        from sys import setrecursionlimit
        setrecursionlimit(10**4)
        corr=dict()
        q=[node]
        while q:
            cur=q.pop()
            corr[cur]=Node()
            for nxt in cur.neighbors:
                if nxt not in corr:
                    q.append(nxt)
        for ex,ne in corr.items():
            ne.val=ex.val
            ne.neighbors=[corr[x] for x in ex.neighbors]
        return corr[node]
