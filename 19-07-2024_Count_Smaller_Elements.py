class Solution:
    def constructLowerArray(self, arr):
        n = len(arr)
        ans = [0] * n
        
        for i in range(n):
            count = 0
            for j in range(i + 1, n):
                if arr[j] < arr[i]:
                    count += 1
            ans[i] = count
        
        return ans
