class Solution:
    def findTriplet(self, arr):
        arr.sort()  # Sort the array
        n = len(arr)

       
        for i in range(n):
            target = arr[i] 
            # Iterate through the array up to the current element
            for j in range(i):
                complement = target - arr[j]
                if complement in seen:
                    #print(f"Triplet found: ({complement}, {arr[j]}, {target})")
                    return True # Exit immediately after finding the first triplet
                seen.add(arr[j])

        return False