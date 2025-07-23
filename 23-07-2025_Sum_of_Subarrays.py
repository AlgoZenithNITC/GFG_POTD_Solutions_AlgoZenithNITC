class Solution:
    def subarraySum(self, arr):
        # code here 
        n = len(arr)
        ans = 0
        count = 0
        for i in range(n):
            ans += arr[i] * (n - count) * (count + 1)
            count += 1
        return ans
        
