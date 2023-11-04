class Solution:
    def transitionPoint(self, arr, n): 
        n = len(arr)
        start = 0
        end = len(arr)
        while start < end:
            mid = start + (end - start)//2
            if arr[mid] <= 0:
                start = mid + 1
            else:
                end = mid
        one_pos = start
        if one_pos >= n:
            return -1
        return one_pos
