class Solution:
    def areIsomorphic(self,s1,s2):
        if len(s1) != len(s2):
            return False
        map = [-1] * 26
        n, used = len(s1), 0
        for i in range(n):
            if map[ord(s1[i]) - ord('a')] != -1:
                if map[ord(s1[i]) - ord('a')] != ord(s2[i]) - ord('a'):
                    return False
            else:
                if used & (1 << ord(s2[i]) - ord('a')):
                    return False
                else:
                    map[ord(s1[i]) - ord('a')] = ord(s2[i]) - ord('a')
                    used |= (1 << ord(s2[i]) - ord('a'))
        return True
