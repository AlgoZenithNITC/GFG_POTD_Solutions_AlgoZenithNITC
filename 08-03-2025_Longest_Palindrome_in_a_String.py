class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        begin, end, max_len = 0, 0, 0

        for i in range(n):
            for j in range(2):
                x, y = i, i + j  # x for odd length, y for even length

                while x >= 0 and y < n and s[x] == s[y]:
                    curr_len = y - x + 1
                    if curr_len > max_len:
                        begin, end, max_len = x, y, curr_len
                    x -= 1
                    y += 1

        return s[begin:end + 1]
