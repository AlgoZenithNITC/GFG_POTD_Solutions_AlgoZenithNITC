class Solution:
    def check(self, arr, mid, k):
        total = 0
        for num in arr:
            total += (num + mid - 1) // mid
            if total > k:
                return False
        return True

    def smallestDivisor(self, arr, k):
        if k == len(arr):
            return max(arr)
        left = 1
        right = max(arr)
        while left < right:
            mid = left + (right - left) // 2
            if self.check(arr, mid, k):
                right = mid
            else:
                left = mid + 1
        return left