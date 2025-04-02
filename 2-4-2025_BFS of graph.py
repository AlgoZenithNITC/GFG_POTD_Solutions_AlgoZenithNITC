class Solution:
    # Function to return Breadth First Search Traversal of given graph.
    def bfs(self, adj):
        # code here
        result = []
        if not adj:
            return result
        
        queue = deque()
        visited = set()
        
        queue.append(0)
        visited.add(0)
        
        while queue:
            current = queue.popleft()
            result.append(current)
            
            for neighbor in adj[current]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
        
        return result