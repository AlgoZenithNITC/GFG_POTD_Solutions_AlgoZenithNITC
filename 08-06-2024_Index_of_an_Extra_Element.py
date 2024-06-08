class Solution:

    def findExtra(self, n, a, b):
        low = 0
        high = n - 2
        index = n - 1

        while (low <= high):
            mid = (low + high) // 2
            if (a[mid] == b[mid]):
                low = mid + 1
            else:
                index = mid
                high = mid - 1

        return index
