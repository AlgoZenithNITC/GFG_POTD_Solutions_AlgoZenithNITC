class Solution {
    static int v_cnt;
    static int e_cnt;

    public static void dfs(List<List<Integer>> adj, int i, boolean[] visited) {
        visited[i] = true;
        v_cnt++;
        e_cnt += adj.get(i).size();

        for (int next : adj.get(i)) {
            if (!visited[next]) {
                dfs(adj, next, visited);
            }
        }
    }

    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[v + 1];
        int ans = 0;

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 1; i <= v; i++) {
            v_cnt = 0;
            e_cnt = 0;
            if (!visited[i]) {
                visited[i] = true;
                dfs(adj, i, visited);

                if (e_cnt == (v_cnt * (v_cnt - 1))) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
