class Solution:
    def getMinDiff(self, arr, n, k):
        arr.sort()
        ans = arr[n - 1] - arr[0]
        minimum = arr[0] + k
        maximum = arr[n - 1] - k
        for i in range(n - 1):
            curr_min = min(arr[i + 1] - k, minimum)
            curr_max = max(arr[i] + k, maximum)
            if curr_min >= 0:
                ans = min(ans, curr_max - curr_min)
        return ans
