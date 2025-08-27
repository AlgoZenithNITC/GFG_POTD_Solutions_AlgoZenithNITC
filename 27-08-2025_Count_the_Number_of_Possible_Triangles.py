class Solution:
    def countTriangles(self, arr):
        # code here
        n = len(arr)
        if n < 3:
            return 0

        arr.sort()
        count = 0

    # Fix the largest side one by one
        for i in range(n - 1, 1, -1):
            left, right = 0, i - 1
            while left < right:
                if arr[left] + arr[right] > arr[i]:
                # all pairs from left to right-1 with arr[right] are valid
                    count += (right - left)
                    right -= 1
                else:
                    left += 1
        return count
        
