// Back-end Complete function Template for JAVA

class Solution
{
    //these list store 4 possible moves from current cell.
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    
    static class Cell
    {
        int x;
        int y;
        int distance;
        
        Cell(int x, int y, int distance) 
        {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    //custom comparator for inserting cells into Priority Queue.
    static class distanceComparator 
      implements Comparator<Cell>
    {
        public int compare(Cell a, Cell b)
        {
            if (a.distance < b.distance)
            {
                return -1;
            }
            else if (a.distance > b.distance)
            {
                return 1;
            }
            else {return 0;}
        }
    }
    
    //Function to check if cell indexes are within bounds.
    static boolean isInsideGrid(int i, int j, int ROW, int COL)
    {
        return (i >= 0 && i < ROW &&j >= 0 && j < COL);
    }
    
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        
        //dp list to store minimum cost to reach each cell.
        int[][] dp = new int[row][col];
    
        //initializing dp array by INT_MAX 
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                dp[i][j] = Integer.MAX_VALUE;
        
        dp[0][0] = grid[0][0];
        
        //using priority queue to store cell indexes and 
        //minimum cost to reach that cell.
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(row * col, new distanceComparator());
                      
        pq.add(new Cell(0, 0, dp[0][0]));
        while (!pq.isEmpty())
        {
            //storing first element of priority queue and popping it.
            Cell curr = pq.poll();
            
            //iterating over 4 possible neighbours of current cell.
            for(int i = 0; i < 4; i++)
            {
                int rows = curr.x + dx[i];
                int cols = curr.y + dy[i];
                
                //if cell indexes are within bounds.
                if (isInsideGrid(rows, cols, grid.length, grid[0].length))
                {
                    //ifdp value at neighbouring cell+current cell value is less
                    //than at current cell, we update dp value at current cell 
                    //and insert cell index with dp value in priority queue.
                    if (dp[rows][cols] >dp[curr.x][curr.y]+grid[rows][cols])
                    {
                        //if cell is already been reached once, we
                        //remove it from priority queue.
                        if (dp[rows][cols] != Integer.MAX_VALUE)
                        {
                            Cell adj = new Cell(rows, cols, dp[rows][cols]);
                            pq.remove(adj);
                        }
                        
                        dp[rows][cols]=dp[curr.x][curr.y]+grid[rows][cols];
                        pq.add(new Cell(rows, cols, dp[rows][cols]));
                    }
                }
            }
        }
        //returning dp value at bottom right corner cell.
        return dp[row - 1][col - 1];

    }
}
