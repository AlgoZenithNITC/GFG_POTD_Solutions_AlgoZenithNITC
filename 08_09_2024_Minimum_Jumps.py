class Solution:
    def minJumps(self, arr):
        n = len(arr)
        
        if n == 1:
            return 0
        
        i = 0
        jumps = 0
        
        while i < n:
            if arr[i] == 0:
                return -1
            
            jumps += 1
            m = i
            
            for j in range(i + 1, min(i + arr[i] + 1, n)):
                if j >= n - 1:
                    return jumps
                
                if arr[j] + j >= arr[m] + m:
                    m = j
            
            i = m
        
        return jumps

