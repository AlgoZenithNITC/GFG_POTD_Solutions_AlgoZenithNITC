bool isCycleUtil(int v, vector<vector<int>> &adj, vector<bool> &visited, int parent)
{
    // Mark the current node as visited
    visited[v] = true;

    // Recur for all the vertices adjacent to this vertex
    for (int i : adj[v])
    {
        // If an adjacent vertex is not visited, then recur for that adjacent
        if (!visited[i])
        {
            if (isCycleUtil(i, adj, visited, v))
                return true;
        }
        // If an adjacent vertex is visited and is not parent of current vertex,
        // then there exists a cycle in the graph.
        else if (i != parent)
            return true;
    }

    return false;
}
vector<vector<int>> constructadj(int V, vector<vector<int>> &edges)
{
    
    vector<vector<int>> adj(V);
    for (auto it : edges)
    {
        adj[it[0]].push_back(it[1]);
        adj[it[1]].push_back(it[0]);
    }
    
    return adj;
}
// Returns true if the graph contains a cycle, else false.
bool isCycle(int V, vector<vector<int>> &edges)
{
    
    vector<vector<int>> adj = constructadj(V,edges);
    // Mark all the vertices as not visited
    vector<bool> visited(V, false);

    for (int u = 0; u < V; u++)
    {
        if (!visited[u])
        {
            if (isCycleUtil(u, adj, visited, -1))
                return true;
        }
    }

    return false;
}