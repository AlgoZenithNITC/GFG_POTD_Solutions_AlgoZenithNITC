class Solution {
  public:
  
    bool DFSCheck(int node, vector<int> &visited, vector<int> &onpath, vector<vector<int>> &adj) {
        visited[node] = 1;
        onpath[node] = 1;
        
        for (auto neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if ( DFSCheck(neighbor, visited, onpath, adj)) {
                    return true;
                }
            } else if (onpath[neighbor]) {
                return true; 
            }
        }
        
        onpath[node] = 0; 
        return false;
    }
  
    bool isCyclic(int V, vector<vector<int>> &edges) {
        vector<vector<int>> adj(V);
        for (auto edge : edges) {
            adj[edge[0]].push_back(edge[1]);
        }
        
        vector<int> visited(V, 0);
        vector<int> onpath(V, 0);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if ( DFSCheck(i, visited, onpath, adj) ) 
                {
                    return true;
                }
            }
        }
        
        return false;
    }
};
