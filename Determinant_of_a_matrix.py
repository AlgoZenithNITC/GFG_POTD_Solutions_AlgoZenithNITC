class Solution:
    def cofactor(self, matrix, temp, R, C, n):
        i = 0
        j = 0
        for row in range(n):
            for col in range(n):
                if row != R and col != C:
                   temp[i][j] = matrix[row][col]
                   j += 1
                   if j == n - 1:
                      j = 0
                      i += 1
    def determinantOfMatrix(self,matrix,n):
        ans = 0
        if n == 1:
            return matrix[0][0]
        temp = [[0] * n for _ in range(n)]
        sign = 1
        for i in range(n):
            self.cofactor(matrix, temp, 0, i, n)
            ans += sign*matrix[0][i]*self.determinantOfMatrix(temp, n - 1)
            sign *= -1
        return ans
