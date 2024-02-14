//JAVA SOLUTION
class Solution {
    private ArrayList<ArrayList<Integer>> ans;
    private int[] low, disc, parent;
    private int time;
    private boolean[] visited;

    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {
        ans = new ArrayList<>();
        low = new int[v];
        disc = new int[v];
        parent = new int[v];
        time = 0;
        visited = new boolean[v];

        // Calling ArticulationPoint function for each unvisited vertex
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArticulationPoint(i, adj);
            }
        }

        // Sorting the output in ascending order
        ans.sort((a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return a.get(1) - b.get(1);
            }
            return a.get(0) - b.get(0);
        });

        return ans;
    }

    private void ArticulationPoint(int u, ArrayList<ArrayList<Integer>> adj) {
        low[u] = time;
        disc[u] = time;
        time++;
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                ArticulationPoint(v, adj);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    ArrayList<Integer> connection = new ArrayList<>();
                    connection.add(Math.min(u, v));
                    connection.add(Math.max(u, v));
                    ans.add(connection);
                }
            } else if (parent[u] != v) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
