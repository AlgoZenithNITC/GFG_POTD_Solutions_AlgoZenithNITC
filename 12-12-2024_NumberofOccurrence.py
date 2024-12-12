class Solution:
    def countFreq(self, arr, target):
          
        n = len(arr)
        start = 0
        end = n - 1

        leftmost = -1
        rightmost = -1

        # Find the leftmost occurrence
        while start <= end:
            mid = (start + end) // 2
            if arr[mid] >= target:
                leftmost = mid
                end = mid - 1
            else:
                start = mid + 1

        if leftmost == -1 or arr[leftmost] != target:
            return 0

        start = 0
        end = n - 1

        # Find the rightmost occurrence
        while start <= end:
            mid = (start + end) // 2
            if arr[mid] <= target:
                rightmost = mid
                start = mid + 1
            else:
                end = mid - 1

        if rightmost == -1 or arr[leftmost] != target:
            return 0

        return (rightmost - leftmost) + 1
