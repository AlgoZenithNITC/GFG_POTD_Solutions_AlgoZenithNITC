class Solution:
    
    def solve(self, i, j, s, t):
        if i <= 0 and j <= 0:
            return 1
        if j <= 0:
            while i >= 0 and s[i - 1] == '*':
                i -= 1
            return 1 if i <= 0 else 0
        if i <= 0 or j <= 0:
            return 0

        a = 0
        if s[i - 1] == t[j - 1]:
            a = self.solve(i - 1, j - 1, s, t)
        elif s[i - 1] == '?':
            a = self.solve(i - 1, j - 1, s, t)
        elif s[i - 1] == '*':
            a = self.solve(i - 1, j - 1, s, t) or self.solve(i, j - 1, s, t) or self.solve(i - 1, j, s, t)
        return a


    def wildCard(self,pattern, string):
        # Code here
        n = len(pattern)
        m = len(string)
        return self.solve(n, m, pattern, string)
