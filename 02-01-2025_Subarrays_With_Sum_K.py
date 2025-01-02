class Solution:
    def countSubarrays(self, arr, k):
        prefix_sums = defaultdict(int)
        res = 0
        total = 0
        for num in arr:
            total += num
            if total == k:
                res += 1
            if (total - k) in prefix_sums:
                res += prefix_sums[total - k]
            prefix_sums[total] += 1
        return res
