class Solution:
    def padovanSequence(self, n):
        # code here 
        mod = 1000000007
        curr = nex = prev = prev2 = 1
        for i in range(3, n+1):
            nex = (prev2 % mod + prev % mod) % mod
            prev2 = prev % mod
            prev = curr % mod
            curr = nex % mod
        return nex % mod
