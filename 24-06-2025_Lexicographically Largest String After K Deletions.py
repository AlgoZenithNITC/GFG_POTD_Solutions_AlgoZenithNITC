class Solution:

    def maxSubseq(self, s: str, k: int) -> str:
        n = len(s)
        res = ""
        # Keep a separate copy of k
        to_remove = k

        # Build the result greedily
        for i in range(n):
            while res and to_remove > 0 and res[-1] < s[i]:
                res = res[:-1]
                to_remove -= 1
            res += s[i]

        # Result should be of length n - k
        return res[:n - k]