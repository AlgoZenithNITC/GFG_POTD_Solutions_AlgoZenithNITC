class Solution:
    def sumTriangles(self,matrix, n):
        upper_sum = 0
        lower_sum = 0
        for i in range(n):
            for j in range(n):
                if i <= j:
                    upper_sum += matrix[i][j]
                if i >= j:
                    lower_sum += matrix[i][j]
        return [upper_sum, lower_sum]
