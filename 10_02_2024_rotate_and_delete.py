
  
from collections import deque

class Solution:
    def rotateDelete(self, arr):
        i = 1
        n = len(arr)
        arr = deque(arr)
        
        while i <= n // 2:
            arr.rotate(1)
            del arr[-i]
            i += 1
        
        return arr[0]

   
        
