class Solution:
    def sequence(self, n):
        # code here
     i = 1
     c = 1
     s = 1
     p = 0
     mod = 1000000007
     while i <= n:
        k = i
        while k > 0:
            s = (s * c) % mod
            c += 1
            k -= 1
        p = (p + s) % mod
        s = 1
        i += 1
     return p