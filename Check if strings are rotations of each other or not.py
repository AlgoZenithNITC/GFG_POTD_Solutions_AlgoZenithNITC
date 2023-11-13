class Solution:
    def areRotations(self,s1,s2):
        return len(s1) == len(s2) and s2 in s1 + s1
