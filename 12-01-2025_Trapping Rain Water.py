class Solution:
    def maxWater(self, arr):
        # code here
        n = len(arr)
        left = [0] * n
        right = [0] * n

        res = 0
        # Fill the left array
        left[0] = arr[0]
        for i in range(1, n):
            left[i] = max(left[i - 1], arr[i])

        # Fill the right array
        right[n - 1] = arr[n - 1]
        for i in range(n - 2, -1, -1):
            right[i] = max(right[i + 1], arr[i])

        # Calculate the accumulated water
        for i in range(1, n - 1):
            min_of_2 = min(left[i - 1], right[i + 1])
            if min_of_2 > arr[i]:
                res += min_of_2 - arr[i]

        return res
