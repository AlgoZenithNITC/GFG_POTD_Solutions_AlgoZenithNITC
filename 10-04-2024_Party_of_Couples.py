class Solution:
    def findSingle(self, n, arr):
        # code here
        ans = arr[0]
        for i in range(1, n):
            ans ^= arr[i]
        return ans

