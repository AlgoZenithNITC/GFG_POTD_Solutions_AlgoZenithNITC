class Solution:

    def maxDistance(self, arr):
        n = len(arr)
        mp = {}
        max_dist = 0
        for i in range(n):
            if arr[i] not in mp:
                mp[arr[i]] = i
            else:
                max_dist = max(max_dist, i - mp[arr[i]])
        return max_dist
