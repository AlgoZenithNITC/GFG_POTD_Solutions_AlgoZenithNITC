from collections import Counter

class Solution:
    def sortByFreq(self, arr):
        freq_map = Counter(arr)
        sorted_items = sorted(freq_map.items(), key=lambda x: (-x[1], x[0]))
        
        ans = []
        for num, freq in sorted_items:
            ans.extend([num] * freq)
        
        return ans

