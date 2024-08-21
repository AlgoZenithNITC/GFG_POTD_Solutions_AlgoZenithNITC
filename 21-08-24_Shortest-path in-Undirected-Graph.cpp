// Back-end complete function Template for C++
class Solution {
  public:
    // Function to find the shortest path from source to all other nodes
    vector<int> shortestPath(vector<vector<int>>& edges, int N, int M,int src)
    {
        vector<int> adj[N + 1];
        
        // Creating adjacency list from given edges
        for (int i = 0; i < M; ++i) {
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
        }
        
        vector<int> dist(N, INT_MAX); // Initializing distance array with maximum distance
        
        queue<int> q; // Creating a queue for BFS
        
        dist[src] = 0; // Distance of source node from itself is 0
        q.push(src); // Adding source node to queue

        // Performing BFS to find shortest path
        while (q.empty() == false)
        {
            int node = q.front();
            q.pop();

            for (auto it : adj[node]) {
                // If the distance of current node + 1 is less than the current distance of adjacent node,
                // then updating distance and adding adjacent node to queue
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.push(it);
                }
            }
        }
        
        // Converting INT_MAX to -1 for nodes that are not reachable from the source
        for(int i=0; i<dist.size(); ++i){
            if(dist[i]==INT_MAX) dist[i] = -1;
        }

        return dist;

    }
};
