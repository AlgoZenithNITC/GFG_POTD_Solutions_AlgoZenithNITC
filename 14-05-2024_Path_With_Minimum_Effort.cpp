class Solution {
  public:
    int MinimumEffort(int rows, int columns, vector<vector<int>> &heights) {
        vector<vector<int>> efforts(rows, vector<int>(columns, INT_MAX));
        vector<vector<int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push({0, {0, 0}});
        
        while (!pq.empty()) {
            auto current = pq.top();
            pq.pop();
            
            int row = current.second.first;
            int col = current.second.second;
            int effort = current.first;
            
            if (row == rows - 1 && col == columns - 1) {
                return effort;
            }
            
            if (effort >= efforts[row][col]) {
                continue;
            }
            
            efforts[row][col] = effort;
            
            for (const auto& dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                    int newEffort = max(effort, abs(heights[row][col] - heights[newRow][newCol]));
                    pq.push({newEffort, {newRow, newCol}});
                }
            }
        }
        
        return -1;
    }
};
