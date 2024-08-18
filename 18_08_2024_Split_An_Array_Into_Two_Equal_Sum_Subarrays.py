class Solution:
    def canSplit(self, arr):
        #code here
        total = sum(arr)
        left_sum = 0
        # Using for loop
        for i in range(len(arr) - 1):
            left_sum += arr[i]
            right_sum = total - left_sum
            
            # check if the left sum and right sum or equal or not
            if left_sum == right_sum:
                return True
        return False
