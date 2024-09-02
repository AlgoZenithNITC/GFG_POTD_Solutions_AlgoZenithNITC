import math
import heapq as hq
class Solution:
    
    #Function to check if cell indexes are within bounds.
    def isValid(self, x, y, n):
        return (x >= 0 and x < n and y >= 0 and y < n)
        
    #Function to return the minimum cost to react at bottom
	#right cell from top left cell.
    def minimumCostPath(self, grid):
        n = len(grid)
        
        #these list store 4 possible moves from current cell.
        dx = [-1,1,0,0]
        dy = [0,0,-1,1]
        s = [0,0]
        q = []
        
        #dp list to store minimum cost to reach each cell.
        dp = [[math.inf for i in range(n)] for j in range(n)]
        dp[0][0] = grid[0][0]
        
        #using a heap queue to store cell indexes and minimum 
        #cost to reach that cell.
        hq.heappush(q, (dp[0][0],s))
        
        while(len(q)):
            
            #storing first element of heap queue and erasing it from heap queue.
            d_v, v = hq.heappop(q)
            
            if(dp[v[0]][v[1]] != d_v):
                continue
            
            #iterating over 4 possible neighbours of current cell.
            for i in range(4):
                x = v[0] + dx[i]
                y = v[1] + dy[i]
                
                #if cell indexes are within bounds and dp value at 
    			#neighbouring cell+current cell value is less than at 
    			#current cell, we update dp value at current cell and
    			#insert cell index with dp value in heap queue.
                if(self.isValid(x,y,n) and dp[x][y]>dp[v[0]][v[1]]+grid[x][y]):
                    dp[x][y] = dp[v[0]][v[1]] + grid[x][y]
                    hq.heappush(q, (dp[x][y], [x,y]))
                    
        #returning dp value at bottom right corner cell.
        return dp[n-1][n-1]
        
        
        
        
        
