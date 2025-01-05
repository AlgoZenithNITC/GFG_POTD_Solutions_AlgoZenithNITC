class Solution:
    def countPairs(self, arr, target):
        arr.sort()
        l, r = 0, len(arr) - 1
        count = 0
        while l < r:
            if arr[l] + arr[r] >= target:
                r -= 1
            else:
                count += r - l
                l += 1
        return count
