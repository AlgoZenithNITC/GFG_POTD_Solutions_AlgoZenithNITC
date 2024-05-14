class Solution {
    public int MinimumEffort(int rows, int columns, int[][] heights) {
        int[][] efforts = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[1];
            int col = current[2];
            int effort = current[0];
            
            if (row == rows - 1 && col == columns - 1) {
                return effort;
            }
            
            if (effort >= efforts[row][col]) {
                continue;
            }
            
            efforts[row][col] = effort;
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[newRow][newCol]));
                    pq.offer(new int[]{newEffort, newRow, newCol});
                }
            }
        }
        
        return -1;
    }
}

