from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs):
        temp = defaultdict(list)
        ans = []
        for s in strs:
            sorted_str = ''.join(sorted(s))
            temp[sorted_str].append(s)
        for anagrams in temp.values():
            ans.append(anagrams)
        return ans

