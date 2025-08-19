from typing import List

class Solution:
    def farMin(self, arr: List[int]) -> List[int]:
        n = len(arr)
        
        suffix = [float('inf')] * (n + 1)
        for i in range(n - 1, -1, -1):
            suffix[i] = min(suffix[i + 1], arr[i])
        
        ans = [-1] * n
        for i in range(n - 1):
            low, high = i + 1, n - 1
            res = -1
            while low <= high:
                mid = (low + high) // 2
                if suffix[mid] < arr[i]:
                    res = mid
                    low = mid + 1  # go right
                else:
                    high = mid - 1
            ans[i] = res
        return ans
