#Back-end complete function Template for Python 3

import sys
sys.setrecursionlimit(10500)
class Solution:
    
    #Function to find the maximum number of cuts.
    def maximizeTheCuts(self, l, p, q, r): 
      
        #creating a dp[] array to store cut at each length
        #and initializing all values with -1.
        dp = [-1]*(l + 1)  
      
        dp[0] = 0
      
        for i in range( l+1) : 
      
            #if certain length is not possible we continue.
            if (dp[i] == -1): 
                continue
     
            #we will update dp[i] if a segment of p,q or r is possible.
            if (i + p <= l): 
                dp[i + p] = (max(dp[i + p],  
                            dp[i] + 1)) 
      
           
            if (i + q <= l): 
                dp[i + q] = (max(dp[i + q],  
                            dp[i] + 1)) 
      
            
            if (i + r <= l): 
                dp[i + r] = (max(dp[i + r], 
                            dp[i] + 1)) 
      
        #if no segment can be cut then we return 0.
        if(dp[l]==-1):
            return 0
            
        #returning the result.
        return dp[l] 
