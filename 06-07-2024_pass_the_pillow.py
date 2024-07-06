class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        mod = 2 * (n - 1)
        time %= mod
        if time < n:
            return time + 1
        else:
            time -= (n - 1)
            return n - time
        return 1
