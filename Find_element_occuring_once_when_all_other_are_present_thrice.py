class Solution:
    def singleElement(self, arr, N):
        once, twice = 0, 0
        for a in arr:
            twice |= once & a
            once ^= a
            not_thrice = ~(once & twice)
            once &= not_thrice
            twice &= not_thrice
        return once
