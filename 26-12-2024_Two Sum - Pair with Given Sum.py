class Solution:
    def twoSum(self, arr, target):
        n = len(arr)
        for i in range(n):
            for j in range(i + 1, n):
                if arr[i] + arr[j] == target:
                    return True
        return False
