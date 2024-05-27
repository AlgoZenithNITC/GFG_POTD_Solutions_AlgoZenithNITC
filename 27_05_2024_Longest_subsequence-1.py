class Solution:
    def solve(self, ind, prev, n, nums):
        # Base case: If the index is beyond the array size, return 0
        if ind >= n:
            return 0

        take, nottake = 0, 0

        # If the previous element is -1 or the absolute difference is 1, consider taking the current element
        if prev == -1 or abs(nums[ind] - nums[prev]) == 1:
            take = 1 + self.solve(ind + 1, ind, n, nums)

        # Consider not taking the current element
        nottake = self.solve(ind + 1, prev, n, nums)

        # Return the maximum of taking or not taking the current element
        return max(take, nottake)
        
    def longestSubsequence(self, N, A):
        # code here
        return self.solve(0, -1, N, A)
