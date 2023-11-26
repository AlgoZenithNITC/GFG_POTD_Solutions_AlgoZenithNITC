class Solution:
    def pattern(self, N):
        b = N
        ans = []
        while N>0:
            ans.append(N)
            N = N - 5
        while N <= b:
            ans.append(N)
            N = N + 5
        return ans
