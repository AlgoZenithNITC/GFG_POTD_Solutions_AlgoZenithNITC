class Solution:
    # Function to search for a key in a rotated sorted array.
    def search(self, arr, key):
        n = len(arr)
        start, end = 0, n - 1
        while start <= end:
            mid = (start + end) // 2

            # If middle element is the key
            if arr[mid] == key:
                return mid

            # If the left part is sorted
            if arr[start] <= arr[mid]:
                if arr[start] <= key <= arr[mid]:
                    # key is in the left part
                    end = mid - 1
                else:
                    # key is in the right part
                    start = mid + 1
            else:  # If the right part is sorted
                if arr[mid] <= key <= arr[end]:
                    # key is in the right part
                    start = mid + 1
                else:
                    # key is in the left part
                    end = mid - 1
        return -1
