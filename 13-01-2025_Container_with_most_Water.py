class Solution:
    def maxWater(self, arr):
        if len(arr) < 2:
            return 0
        left = 0
        right = len(arr) - 1
        max_val = 0

        while left < right:
            temp = min(arr[left], arr[right]) * (right - left)
            max_val = max(max_val, temp)

            if arr[left] < arr[right]:
                left += 1
            else:
                right -= 1

        return max_val
