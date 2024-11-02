class Solution:
    def isCircularSentence(self, s):
        for i in range(1, len(s) - 1):
            if s[i] == ' ' and s[i - 1] != s[i + 1]:
                return False  # checking for circular substring condition
        if s[0] != s[-1]:  # checking for circular whole string condition
            return False
        return True
