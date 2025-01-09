class Solution:
    def subarraySum(self, arr, target):
        start = 0
        current_sum = 0

        for end in range(len(arr)):
            current_sum += arr[end]

            # Shrink the window as long as the sum is greater than the target
            while current_sum > target and start <= end:
                current_sum -= arr[start]
                start += 1

            # Check if the current sum equals the target
            if current_sum == target:
                return [start + 1, end + 1]  # Return 1-based indices

        # If no subarray is found, return [-1]
        return [-1]
