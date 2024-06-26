class Solution:
    
    def count(self,i, j, matrix, n, m):
        ans = 0
        if i-1 >= 0 and matrix[i-1][j] == 1:
            ans += 1
        if i+1 < n and matrix[i+1][j] == 1:
            ans += 1
        if j-1 >= 0 and matrix[i][j-1] == 1:
            ans += 1
        if j+1 < m and matrix[i][j+1] == 1:
            ans += 1
        
        return ans
    
    def findCoverage(self, matrix):
        ans = 0
        n = len(matrix)
        m = len(matrix[0])
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    ans += self.count(i, j, matrix, n, m)
        
        return ans
