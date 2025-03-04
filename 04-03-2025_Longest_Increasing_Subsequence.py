class Solution:
    def lis(self, arr):
        if not arr:
            return 0
        
        lis = [1] * len(arr)
        
        for i in range(1, len(arr)):
            for j in range(i):
                if arr[i] > arr[j]:
                    lis[i] = max(lis[i], lis[j] + 1)
        
        return max(lis)

