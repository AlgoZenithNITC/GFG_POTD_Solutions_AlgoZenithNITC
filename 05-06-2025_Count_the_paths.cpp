class Solution {
  public:
    int countPaths(vector<vector<int>>& edges, int V, int src, int dest) {
        // build the graph
        vector<vector<int>> graph(V);
        vector<int> indegree(V, 0);

        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            indegree[e[1]]++;
        }

        // topological sort (Kahn's algorithm)
        queue<int> q;
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.push(i);
        }

        vector<int> topo;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            topo.push_back(node);
            for (int nei : graph[node]) {
                indegree[nei]--;
                if (indegree[nei] == 0)
                    q.push(nei);
            }
        }

        // dp[i] stores number of paths from i to destination
        vector<int> dp(V, 0);
        dp[dest] = 1;

        // reverse process of topo sort
        for (int i = V - 1; i >= 0; i--) {
            int node = topo[i];
            for (int nei : graph[node]) {
                dp[node] += dp[nei];
            }
        }

        return dp[src];
    }
};
