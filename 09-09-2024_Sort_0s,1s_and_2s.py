class Solution:
    # Function to sort an array of 0s, 1s, and 2s
    def sort012(self, arr):
        low, mid, high = 0, 0, len(arr) - 1

        # Using the Dutch National Flag algorithm
        while mid <= high:
            if arr[mid] == 0:
                arr[low], arr[mid] = arr[mid], arr[low]  # Swap the elements
                low += 1
                mid += 1
            elif arr[mid] == 1:
                mid += 1
            else:
                arr[mid], arr[high] = arr[high], arr[mid]  # Swap the elements
                high -= 1
