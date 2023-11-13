class Solution:
    def areRotations(self,s1,s2):
        return s2 in s1 + s1
