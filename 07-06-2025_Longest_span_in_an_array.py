class Solution:
    def longestCommonSum(self, a1, a2):
        n = len(a1)
        diff_map = {0: -1}
        sum_diff = 0
        max_len = 0

        for i in range(n):
            sum_diff += a1[i] - a2[i]
            if sum_diff in diff_map:
                max_len = max(max_len, i - diff_map[sum_diff])
            else:
                diff_map[sum_diff] = i

        return max_len
