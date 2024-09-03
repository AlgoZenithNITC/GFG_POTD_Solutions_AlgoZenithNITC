
class Solution:
    def solve(self, i, j, str1, str2, memo):
        if i >= len(str1) or j >= len(str2):
            return 0
        
        if memo[i][j] != -1:
            return memo[i][j]
        
        a = 0
        if str1[i] == str2[j]:
            a = 1 + self.solve(i + 1, j + 1, str1, str2, memo)
        
        b, c = 0, 0
        if str1[i] != str2[j]:
            b = self.solve(i + 1, j, str1, str2, memo)
            c = self.solve(i, j + 1, str1, str2, memo)
        
        memo[i][j] = max(a, max(b, c))
        return memo[i][j]

    def minOperations(self, str1, str2):
        memo = [[-1 for _ in range(len(str2))] for _ in range(len(str1))]
        lcs = self.solve(0, 0, str1, str2, memo)
        
        return (len(str1) - lcs) + (len(str2) - lcs)


