class Solution:
    def longestUniqueSubstr(self, s):
        t = 0
        ans = ''
        for i in range(len(s)):
            if s[i] not in ans:
                ans += s[i]
                t = max(len(ans), t)
            else:
                ans = ans[ans.index(s[i]) + 1:] + s[i]
        return t