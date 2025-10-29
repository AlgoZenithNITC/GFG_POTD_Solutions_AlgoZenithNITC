import java.util.*;

class Solution {

    public int[] bfs(int start, List<List<Integer>> adj, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        int farthestNode = start;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nbr : adj.get(node)) {
                if (dist[nbr] == -1) {
                    dist[nbr] = dist[node] + 1;
                    q.offer(nbr);
                    if (dist[nbr] > dist[farthestNode]) {
                        farthestNode = nbr;
                    }
                }
            }
        }
        return new int[]{farthestNode, dist[farthestNode]};
    }

    public int diameter(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] first = bfs(0, adj, V);
        int nodeA = first[0];
        int[] second = bfs(nodeA, adj, V);

        return second[1];
    }
}
