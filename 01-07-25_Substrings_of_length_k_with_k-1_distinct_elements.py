class Solution:
    def substrCount(self, s, k):
        res = 0
        distinct = 0
        freq = [0] * 26

        for i in range(k):
            idx = ord(s[i]) - ord('a')
            freq[idx] += 1
            if freq[idx] == 1:
                distinct += 1

        if distinct == k - 1:
            res += 1

        for i in range(k, len(s)):
            out_idx = ord(s[i - k]) - ord('a')
            freq[out_idx] -= 1
            if freq[out_idx] == 0:
                distinct -= 1

            in_idx = ord(s[i]) - ord('a')
            freq[in_idx] += 1
            if freq[in_idx] == 1:
                distinct += 1

            if distinct == k - 1:
                res += 1

        return res
