class Solution:
    def findMaxProduct(self, nums):
        size = len(nums)
        if size == 1:
            return nums[0]

        result = 1
        mod = 1000000007
        min_neg_index = -1
        min_neg_value = 0
        zero_count = 0
        neg_count = 0

        for i in range(size):
            if nums[i] == 0:
                zero_count += 1
            elif nums[i] < 0:
                neg_count += 1
                if min_neg_index == -1 or nums[i] > min_neg_value:
                    min_neg_index = i
                    min_neg_value = nums[i]

        if zero_count == size:
            return 0

        if neg_count == 1 and zero_count == size - 1:
            return 0

        for i in range(size):
            if nums[i] == 0:
                continue
            if neg_count % 2 == 1 and i == min_neg_index:
                continue
            result = ((result * nums[i]) % mod + mod) % mod

        return result
