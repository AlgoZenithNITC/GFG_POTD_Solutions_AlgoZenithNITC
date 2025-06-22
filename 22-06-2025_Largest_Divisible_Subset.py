
class Solution:
    def largestSubset(self, arr: List[int]) -> List[int]:
        n = len(arr)
        arr.sort()

        dp = [1] * n
        parent = [-1] * n
        maxSize = 1
        maxIdx = 0

        for i in range(n - 1, -1, -1):
            for j in range(n - 1, i, -1):
                if arr[j] % arr[i] == 0:
                    if dp[j] + 1 > dp[i]:
                        dp[i] = dp[j] + 1
                        parent[i] = j
                    elif dp[j] + 1 == dp[i] and (parent[i] == -1 or arr[j] > arr[parent[i]]):
                        parent[i] = j

            if dp[i] > maxSize or (dp[i] == maxSize and arr[i] > arr[maxIdx]):
                maxSize = dp[i]
                maxIdx = i

        subset = []
        curr = maxIdx
        while curr != -1:
            subset.append(arr[curr])
            curr = parent[curr]

        return subset
