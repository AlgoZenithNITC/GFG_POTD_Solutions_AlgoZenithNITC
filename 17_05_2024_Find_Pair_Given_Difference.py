from typing import List
class Solution:
    def findPair(self, n : int, x : int, arr : List[int]) -> int:
        s = set(arr)
        if x == 0 and len(arr) == len(s):
            return -1 
        for i in range(n):
            if (arr[i]+x) in s or (arr[i]-x) in s:
                return 1      
        return -1
