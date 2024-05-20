class Solution:
    def PowMod(self, x, n, m):
        res = 1
        while n > 0:
            if n % 2 == 1:
                res = ((res % m) * (x % m)) % m
            x = (x * x) % m
            n = n // 2
        return res
