class Solution:
    def countPairsWithDiffK(self, arr, k):
        maxi = 0
        size = len(arr)
        count = 0
        for i in range(size):
            if arr[i] > maxi:
                maxi = arr[i]
        
        ht = [0] * (maxi + 1)
        for i in range(size):
            ht[arr[i]] += 1
        
        for i in range(size):
            curr = arr[i]
            if curr + k <= maxi and ht[curr + k]:
                count += ht[curr + k]
        
        return count
