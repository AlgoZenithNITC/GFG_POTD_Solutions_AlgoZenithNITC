class Solution:

    def doOneSwap(self, n, arr):
        for i in range(n):
            if arr[i] != i + 1:
                for j in range(i + 1, n):
                    if arr[j] == i + 1:
                        arr[i], arr[j] = arr[j], arr[i]
                        return

    def checkSorted(self, arr):
        n = len(arr)
        misMatch = 0

        # Count the number of mismatches
        for i in range(n):
            if arr[i] != i + 1:
                misMatch += 1

        # Handle edge cases based on mismatch count
        if n == 1:
            return False
        if misMatch == 0 or misMatch == 3:
            return True
        if misMatch != 4:
            return False

        # Try to sort the array with two swaps
        self.doOneSwap(n, arr)
        self.doOneSwap(n, arr)

        # Check if the array is now sorted
        for i in range(n):
            if arr[i] != i + 1:
                return False

        return True
