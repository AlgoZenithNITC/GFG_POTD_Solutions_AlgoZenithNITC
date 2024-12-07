class Solution:
    # User function Template for python3
    # Function to count inversions in the array.
    def inversionCount(self, arr):
        def mergeAndCount(arr, l, m, r):
            n1 = m - l + 1
            n2 = r - m
            count = 0

            left = arr[l:m+1] + [float('inf')]
            right = arr[m+1:r+1] + [float('inf')]

            i, j, k = 0, 0, l
            while i < n1 and j < n2:
                if left[i] <= right[j]:
                    arr[k] = left[i]
                    i += 1
                else:
                    arr[k] = right[j]
                    j += 1
                    count += n1 - i
                k += 1

            while i < n1:
                arr[k] = left[i]
                i += 1
                k += 1

            while j < n2:
                arr[k] = right[j]
                j += 1
                k += 1

            return count

        def divideAndCount(arr, l, r):
            count = 0
            if l < r:
                m = (l + r) // 2
                count += divideAndCount(arr, l, m)
                count += divideAndCount(arr, m + 1, r)
                count += mergeAndCount(arr, l, m, r)
            return count

        return divideAndCount(arr, 0, len(arr) - 1)
