class Solution:
    def distinct(self, s):
        mp = {}
        total = 0
        for i in range(len(s)):
            present = total + 1
            if s[i] in mp:
                total += (present - mp[s[i]])
            else:
                total += present
            mp[s[i]] = present
        return total
    
    def betterString(self, str1, str2):
        distinct_one = Solution().distinct(str1)
        distinct_two = Solution().distinct(str2)
        return str1 if distinct_one >= distinct_two else str2
