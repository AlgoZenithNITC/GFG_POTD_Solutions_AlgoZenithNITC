
class Solution:
    def solve(self, i, j, s1, s2, memo):
        if i < 0:
            return j + 1
        if j < 0:
            return i + 1
        
        if memo[i][j] != -1:
            return memo[i][j]
        
        if s1[i] == s2[j]:
            return self.solve(i - 1, j - 1, s1, s2, memo)
        
        a = 1 + self.solve(i - 1, j, s1, s2, memo)  # remove
        b = 1 + self.solve(i, j - 1, s1, s2, memo)  # insert
        c = 1 + self.solve(i - 1, j - 1, s1, s2, memo)  # replace
        
        memo[i][j] = min(a, min(b, c))
        return memo[i][j]
    
    def editDistance(self, str1, str2):
        n, m = len(str1), len(str2)
        memo = [[-1 for _ in range(m)] for _ in range(n)]
        return self.solve(n - 1, m - 1, str1, str2, memo)
