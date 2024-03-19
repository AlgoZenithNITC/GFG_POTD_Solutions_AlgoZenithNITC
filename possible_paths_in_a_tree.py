

class Solution:
    def maximumWeight(self, n, edges, q, queries):
        
        par = [i for i in range(n)]
        rank = [1 for _ in range(n)]
        
        def find (n1):
            while (par[n1] != n1):
                par[n1] = par[par[n1]]
                n1 = par[n1]
            return par[n1]
        edges.sort(key = lambda x : x[2], reverse = True)
        queries = sorted(enumerate(queries) , key = lambda x :x[1])
        
        res = [0]*q
        cur = 0
        for idx, x in queries:
            while edges and edges[-1][2] <= x :
                u,v,wt = edges.pop()
                u, v = find(u-1), find(v-1)
                if u != v:
                    par[v] = u 
                    cur += rank[u] * rank[v]
                    rank[u] += rank[v]
            res[idx] = cur
            
        return res
