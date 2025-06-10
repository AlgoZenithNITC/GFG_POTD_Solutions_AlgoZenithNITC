from collections import Counter

class Solution:
    def maxDifference(self, s: str) -> int:
        freq = Counter(s)
        maxf = 0
        minf = len(s)

        for count in freq.values():
            if count % 2 == 1:
                maxf = max(maxf, count)
            else:
                minf = min(minf, count)
        
        if minf == len(s):
            return maxf
        return maxf - minf
