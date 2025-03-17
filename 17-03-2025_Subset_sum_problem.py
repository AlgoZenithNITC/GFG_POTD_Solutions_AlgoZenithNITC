def isSubsetSum (self, arr, sum):
      # code here 
      n = len(arr)
      dp = [[False] * (sum + 1) for _ in range(n + 1)]
    
      for i in range(n + 1):
          dp[i][0] = True  # Base case: sum = 0 is always possible with an empty subset
    
      for i in range(1, n + 1):
          for j in range(1, sum + 1):
              if arr[i - 1] > j:
                  dp[i][j] = dp[i - 1][j]  # Exclude the current element
              else:
                  dp[i][j] = dp[i - 1][j] or dp[i - 1][j - arr[i - 1]]  # Include or exclude the element
    
      return dp[n][sum]
