class Solution:
    def binaryNextNumber(self, s):
        ans = ""
        for ch in s[::-1]:
            if ch == '1':
                ans = '0' + ans
            else:
                ans = '1' + ans
                break
        ans = s[:len(s) - len(ans)] + ans
        if ans == '0' * len(s):
            ans = '1' + ans
        else:
            while ans[0] == '0':
                ans = ans[1:]
        return ans
