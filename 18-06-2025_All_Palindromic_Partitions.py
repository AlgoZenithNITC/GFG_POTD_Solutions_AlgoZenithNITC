class Solution:
    # Precompute all palindromic substrings in s
    def palindromes(self, s, dp):
        n = len(s)

        # All single characters are palindromes
        for i in range(n):
            dp[i][i] = True

        # Check two-character substrings
        for i in range(n - 1):
            dp[i][i + 1] = (s[i] == s[i + 1])

        # Check substrings of length 3 or more using bottom-up DP
        for length in range(3, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]

    # Recursive function to find all palindromic partitions
    def backtrack(self, idx, s, curr, res, dp):
        # If we have reached the end of the string, store current partition
        if idx == len(s):
            res.append(list(curr))
            return

        # Try all substrings starting from index idx
        for i in range(idx, len(s)):
            # If s[idx..i] is a palindrome, we can include it
            if dp[idx][i]:
                # Choose the substring
                curr.append(s[idx:i + 1])
                # Explore further from next index
                self.backtrack(i + 1, s, curr, res, dp)
                # Undo the choice (backtrack)
                curr.pop()

    # Return all palindromic partitions of string s
    def palinParts(self, s):
        n = len(s)
        # DP table to store if substring s[i..j] is a palindrome
        dp = [[False] * n for _ in range(n)]

        # Precompute all palindromic substrings using DP
        self.palindromes(s, dp)

        # Final result
        res = []
        # Current partition
        curr = []
        # Begin backtracking from index 0
        self.backtrack(0, s, curr, res, dp)
        return res