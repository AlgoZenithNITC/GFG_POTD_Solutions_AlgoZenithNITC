class Solution:
    def longestSubarray(self, arr, k):
        n = len(arr)
        prefix_sum_map = {}
        ans = 0
        psum = 0

        for i in range(n):
            psum += arr[i]

            if psum == k:
                ans = i + 1

            if psum - k in prefix_sum_map:
                ans = max(ans, i - prefix_sum_map[psum - k])

            if psum not in prefix_sum_map:
                prefix_sum_map[psum] = i

        return ans
