

class GfG 
{
    // Helper function to check cycle using DFS
    static boolean isCycleUtil(int v, List<Integer>[] adj,boolean[] visited,int parent)
    {
        visited[v] = true;
        // If an adjacent vertex is not visited,
        // then recur for that adjacent
        for (int i : adj[v]) 
        {
            if (!visited[i]) 
            {
                if (isCycleUtil(i, adj, visited, v))
                    return true;
            }
            // If an adjacent vertex is visited and
            // is not parent of current vertex,
            // then there exists a cycle in the graph.
            else if (i != parent) 
            {
                return true;
            }
        }
        return false;
    }
    static  List<Integer>[] constructadj(int V, int [][] edges)
    {
        
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) 
        {
            adj[i] = new ArrayList<>();
        }
        
        return adj;
    } 
    // Function to check if graph contains a cycle
    static boolean isCycle(int V, int[][] edges)
    {
        List<Integer> [] adj = constructadj(V,edges);
        
        for (int[] edge : edges) 
        {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        // Call the recursive helper function
        // to detect cycle in different DFS trees
        for (int u = 0; u < V; u++) 
        {
            if (!visited[u]) 
            {
                if (isCycleUtil(u, adj, visited, -1))
                    return true;
            }
        }
        return false;
    }

}