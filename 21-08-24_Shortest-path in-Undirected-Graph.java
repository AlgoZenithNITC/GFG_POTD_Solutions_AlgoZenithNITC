class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Creating an adjacency list to represent the graph
        ArrayList<Integer> adj[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Adding edges to the adjacency list
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        // Array to store the shortest distance from source to each node
        int dis[] = new int[n];
        // Queue to perform Breadth First Search
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        // Initializing the distance array with maximum values
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        // Array to keep track of visited nodes
        boolean vis[] = new boolean[n];
        vis[src] = true;
        
        // Performing BFS to find the shortest path
        while (!que.isEmpty()) {
            int u = que.poll();
            for (int v : adj[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    dis[v] = dis[u] + 1;
                    que.add(v);
                }
            }
        }
        
        // Updating the unreachable nodes with -1
        for (int i = 0; i < n; ++i) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = -1;
            }
        }
        
        // Returning the shortest distance array
        return dis;
    }
}
