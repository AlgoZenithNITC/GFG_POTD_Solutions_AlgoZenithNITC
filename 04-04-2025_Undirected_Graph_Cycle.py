# Helper function to check cycle using DFS
def isCycleUtil(v, adj, visited, parent):
    visited[v] = True

    for i in adj[v]:
        if not visited[i]:
            if isCycleUtil(i, adj, visited, v):
                return True
        elif i != parent:
            return True
    return False

def constructadj(V, edges):
    adj = [[] for _ in range(V)]  # Initialize adjacency list

    for edge in edges:
        u, v = edge
        adj[u].append(v)
        adj[v].append(u)
    
    return adj

# Function to check if graph contains a cycle
def isCycle(V, edges):
    
    adj = constructadj(V,edges)
    visited = [False] * V

    for u in range(V):
        if not visited[u]:
            if isCycleUtil(u, adj, visited, -1):
                return True
    return False


