class Solution:

    def rearrange(self, arr):
        # Initialize two lists to store positive and negative numbers
        pos = []
        neg = []
        n = len(arr)
        # Iterate through the input array and separate positive and negative numbers
        for i in range(n):
            if arr[i] < 0:
                neg.append(arr[i])
            else:
                pos.append(arr[i])

        # Initialize variables for iteration through pos and neg lists
        i = 0
        j = 0
        k = 0

        # Merge the positive and negative numbers alternatively into the result array
        while i < len(neg) and j < len(pos):
            arr[k] = pos[j]
            j += 1
            k += 1
            arr[k] = neg[i]
            i += 1
            k += 1

        # If there are remaining positive or negative numbers, add them to the result array
        while j < len(pos):
            arr[k] = pos[j]
            j += 1
            k += 1

        while i < len(neg):
            arr[k] = neg[i]
            i += 1
            k += 1


""" 
Initialize two lists to store positive and negative numbers
Iterate through the input array and separate positive and negative numbers
Merge the positive and negative numbers alternatively into the result array
If there are remaining positive or negative numbers, add them to the result array 
"""
