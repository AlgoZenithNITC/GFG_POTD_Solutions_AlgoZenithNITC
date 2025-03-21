class Solution:  
    def findMaxSum(self,arr):
        # code here
        n = len(arr)
    
        if n == 0:
            return 0
        elif n == 1:
            return arr[0]
    
    # dp array to store the maximum loot at each house
        dp = [0] * n
    
    # Base cases
        dp[0] = arr[0]
        dp[1] = max(arr[0], arr[1])
    
    # Fill the dp array for each house from index 2 to n-1
        for i in range(2, n):
            dp[i] = max(dp[i-1], arr[i] + dp[i-2])
    
    # The last element in dp will have the maximum loot
        return dp[n-1]
