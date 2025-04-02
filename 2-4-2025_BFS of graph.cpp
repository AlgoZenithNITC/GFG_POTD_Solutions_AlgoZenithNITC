class Solution {
    public:
      // Function to return Breadth First Traversal of given graph.
      vector<int> bfs(vector<vector<int>> &adj) {
            vector<int> result;
          if (adj.empty()) return result;
          
          queue<int> q;
          unordered_set<int> visited;
          
          q.push(0);
          visited.insert(0);
          
          while (!q.empty()) {
              int current = q.front();
              q.pop();
              result.push_back(current);
              
              for (int neighbor : adj[current]) {
                  if (visited.find(neighbor) == visited.end()) {
                      visited.insert(neighbor);
                      q.push(neighbor);
                  }
              }
          }
          
          return result;
      
          
      }
  };