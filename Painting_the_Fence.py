class Solution:
    def countWays(self,n,k):
        total = k
        same = 0
        diff = k
        mod = int(1e9) + 7
        for i in range(2, n + 1):
            same = diff
            diff = (total % mod * (k - 1) % mod) % mod
            total = (same + diff) % mod
        return total
