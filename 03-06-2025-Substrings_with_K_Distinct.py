class Solution:
    def atMostK(self, s, k):
        n = len(s)
        count = [0] * 26  # for lowercase English letters
        i = 0
        res = 0
        distinct = 0

        for j in range(n):
            if count[ord(s[j]) - ord('a')] == 0:
                distinct += 1
            count[ord(s[j]) - ord('a')] += 1

            while distinct > k:
                count[ord(s[i]) - ord('a')] -= 1
                if count[ord(s[i]) - ord('a')] == 0:
                    distinct -= 1
                i += 1

            res += j - i + 1

        return res

    def countSubstr(self, s, k):
        return self.atMostK(s, k) - self.atMostK(s, k - 1)
