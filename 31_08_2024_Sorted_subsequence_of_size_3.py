#Back-end complete function Template for Python 3


class Solution:

    def find3Numbers(self, arr):
        n = len(arr)
        max_idx = n - 1
        min_idx = 0

        smaller = [-1] * n
        smaller[0] = -1
        for i in range(1, n):
            if arr[i] <= arr[min_idx]:
                min_idx = i
                smaller[i] = -1
            else:
                smaller[i] = min_idx

        greater = [-1] * n
        greater[n - 1] = -1
        for i in range(n - 2, -1, -1):
            if arr[i] >= arr[max_idx]:
                max_idx = i
                greater[i] = -1
            else:
                greater[i] = max_idx

        result = []
        for i in range(n):
            if smaller[i] != -1 and greater[i] != -1:
                result.append(arr[smaller[i]])
                result.append(arr[i])
                result.append(arr[greater[i]])
                return result
        return result
