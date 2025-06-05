class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {

        // to make graph
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // add all edges and calculate in-degree
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        // to make topological sorting
        Queue<Integer> q = new LinkedList<>();

        // insert all vertices which don't have any parent
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        List<Integer> topo = new ArrayList<>();

        // using kahn's algorithm for topological sorting
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int nei : graph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.add(nei);
            }
        }

        // to store number of ways
        int[] dp = new int[V];
        dp[dest] = 1;

        // traverse in reverse topological order
        for (int i = topo.size() - 1; i >= 0; i--) {
            int u = topo.get(i);
            for (int nei : graph.get(u)) {
                dp[u] += dp[nei];
            }
        }

        return dp[src];
    }
}