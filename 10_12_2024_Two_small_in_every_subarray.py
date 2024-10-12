
class Solution:
    def pairWithMaxSum(self, arr):
        n = len(arr)
        if n == 1:
            return -1
        ans = float('-inf')

        for i in range(1, n):
            ans = max(ans, arr[i] + arr[i - 1])

        return ans
