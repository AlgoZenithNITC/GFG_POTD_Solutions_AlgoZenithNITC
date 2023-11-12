class Solution:
    def shortestCommonSupersequence(self, X, Y, m, n):
       prev = [0] * (n + 1)
       curr = [0] * (n + 1)
       for i in range(1, m + 1):
           for j in range(1, n + 1):
               if X[i - 1] == Y[j - 1]:
                   curr[j] = 1 + prev[j - 1]
               else:
                   curr[j] = max(curr[j - 1], prev[j])
           prev = curr[:]
       lcs = curr[n]
       return n + m - lcs
