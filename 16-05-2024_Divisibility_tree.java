class Solution {
    private int ans = 0; // declare globally
    
    private int dfs(int start, List<List<Integer>> adj, boolean[] visited) {
        int count = 0; // storing size of subtree
        int result = 0;
        visited[start] = true;
        for (int it : adj.get(start)) {
            if (!visited[it]) {
                result = dfs(it, adj, visited); // result is storing size of subtree
                if (result % 2 == 0) {
                    ans++;
                } else {
                    count += result;
                }
            }
        }
        return count + 1;
    }
    
    public int minimumEdgeRemove(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u - 1).add(v - 1);
            adj.get(v - 1).add(u - 1);
        }
        
        dfs(0, adj, visited);
        return ans;
    }
}
