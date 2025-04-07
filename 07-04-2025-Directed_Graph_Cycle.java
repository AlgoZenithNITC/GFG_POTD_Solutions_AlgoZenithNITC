class Solution {
    
    private boolean dfsCheck(int node, int[] visited, int[] onpath, List<List<Integer>> adj) {
        visited[node] = 1;
        onpath[node] = 1;
        
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                if (dfsCheck(neighbor, visited, onpath, adj)) {
                    return true;
                }
            } else if (onpath[neighbor] == 1) {
                return true;
            }
        }
        
        onpath[node] = 0; 
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        int[] visited = new int[V];
        int[] onpath = new int[V];
        
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfsCheck(i, visited, onpath, adj)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
