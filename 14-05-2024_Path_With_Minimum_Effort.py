class Solution:
    def MinimumEffort(self, rows: int, columns: int, heights: List[List[int]]) -> int:
        efforts = [[float('inf')] * columns for _ in range(rows)]
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        
        pq = [(0, (0, 0))]
        efforts[0][0] = 0
        
        while pq:
            effort, (row, col) = heappop(pq)
            
            if row == rows - 1 and col == columns - 1:
                return effort
            
            if effort > efforts[row][col]:
                continue
            
            for dr, dc in directions:
                new_row, new_col = row + dr, col + dc
                
                if 0 <= new_row < rows and 0 <= new_col < columns:
                    new_effort = max(effort, abs(heights[row][col] - heights[new_row][new_col]))
                    if new_effort < efforts[new_row][new_col]:
                        efforts[new_row][new_col] = new_effort
                        heappush(pq, (new_effort, (new_row, new_col)))
        
        return -1

