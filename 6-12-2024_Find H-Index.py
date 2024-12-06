class Solution:
    def hIndex(self, citations):
        citations.sort()
        n = len(citations)
        hIndex = 0
        for i in range(n):
            if citations[i] >= n - i:
                hIndex = n - i
                break
        return hIndex
