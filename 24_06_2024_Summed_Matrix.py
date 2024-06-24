class Solution:
    def sumMatrix(self, n, q):
        return max(min(q, 2 * (n + 1) - q) - 1, 0)
