class Solution:
    def maxLen(self, arr):
        # Dictionary to store the first occurrence of prefix sum
        prefixSum = {}
        n = len(arr)
        sum = 0
        ans = 0
        
        for i in range(n):
            # Update the prefix sum: treat 1 as +1 and -1 as -1
            sum += 1 if arr[i] == 1 else -1
            
            # If sum is zero, the subarray from the start to i has sum zero
            if sum == 0:
                ans = i + 1
            
            # If the sum has been seen before, calculate the subarray length
            if sum in prefixSum:
                ans = max(ans, i - prefixSum[sum])
            else:
                # Store the first occurrence of this prefix sum
                prefixSum[sum] = i
        
        return ans
