class Solution:
    def getLongestPrefix(self, s):
        n = len(s)
        if n <= 1:
            return -1

        # Build LPS (prefix function)
        lps = [0] * n
        length = 0
        i = 1
        while i < n:
            if s[i] == s[length]:
                length += 1
                lps[i] = length
                i += 1
            elif length != 0:
                length = lps[length - 1]
            else:
                lps[i] = 0
                i += 1

        b = lps[-1]  # largest border length
        if b == 0:
            return -1  # no border → no periodic proper prefix

        # Walk down the border chain to the smallest positive border
        while b > 0 and lps[b - 1] > 0:
            b = lps[b - 1]

        return n - b 
