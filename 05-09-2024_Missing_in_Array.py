class Solution:
    
    # Note that the size of the array is n-1
    def missingNumber(self, n, arr):
        
        # code here
        totalsum = (n * (n+1))//2
        for i in range(n-1):
            totalsum -= arr[i]
        
        return totalsum
