class Solution:
    def findPeakElement(self, a: List[int]) -> int:
        max_val = a[0]
        for i in range(1, len(a)):
            if a[i] > max_val:
                max_val = a[i]
            else:
                return max_val
        return max_val

