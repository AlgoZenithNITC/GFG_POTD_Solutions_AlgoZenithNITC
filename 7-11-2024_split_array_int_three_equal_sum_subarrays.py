class Solution:
    def findSplit(self, arr):
        total_sum = sum(arr)
        
        # If the total sum is not divisible by 3, return [-1, -1]
        if total_sum % 3 != 0:
            return [-1, -1]
        
        target = total_sum // 3
        n = len(arr)
        
        # First pass: Find the first partition point (i)
        current_sum = 0
        for i in range(n):
            current_sum += arr[i]
            if current_sum == target:
                # Now look for the second partition
                second_sum = 0
                for j in range(i + 1, n):
                    second_sum += arr[j]
                    if second_sum == target:
                        # If we find the second partition, the rest will be the third
                        return [i, j]
        
        # If no valid partition found, return [-1, -1]
        return [-1, -1]

# Example usage:
solution = Solution()

# Example 1
arr1 = [1, 3, 4, 0, 4]
result1 = solution.findSplit(arr1)
#print(result1)  # Output: [1, 3] or some valid pair of indices

# Example 2
arr2 = [2, 3, 4]
result2 = solution.findSplit(arr2)
#print(result2)  # Output: [-1, -1]

# Example 3
arr3 = [0, 1, 1]
result3 = solution.findSplit(arr3)
#print(result3)  # Output: [-1, -1]

