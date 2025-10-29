class Solution {
  public:
    pair<int, int> bfs(int start, vector<vector<int>>& adj, int V) {
        vector<int> dist(V, -1);
        queue<int> q;
        q.push(start);
        dist[start] = 0;
        int farthestNode = start;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            for (auto &nbr : adj[node]) {
                if (dist[nbr] == -1) {
                    dist[nbr] = dist[node] + 1;
                    q.push(nbr);
                    if (dist[nbr] > dist[farthestNode])
                        farthestNode = nbr;
                }
            }
        }
        return {farthestNode, dist[farthestNode]};
    }
    int diameter(int V, vector<vector<int>>& edges) {
        vector<vector<int>> adj(V);
        for (auto &edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        auto first = bfs(0, adj, V);
        int nodeA = first.first;
        auto second = bfs(nodeA, adj, V);
        return second.second;
    }
};
