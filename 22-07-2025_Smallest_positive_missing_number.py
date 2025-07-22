class Solution:
    def missingNumber(self, arr):
        n = len(arr)

        # Place each number in its correct index if possible
        for i in range(n):
            while 1 <= arr[i] <= n and arr[i] != arr[arr[i] - 1]:
                arr[arr[i] - 1], arr[i] = arr[i], arr[arr[i] - 1]

        # Find the first index where the number is incorrect
        for i in range(n):
            if arr[i] != i + 1:
                return i + 1

        return n + 1
