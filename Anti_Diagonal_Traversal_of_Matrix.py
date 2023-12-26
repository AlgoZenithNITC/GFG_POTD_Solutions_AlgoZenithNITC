class Solution:
    def antiDiagonalPattern(self, matrix):
        result = []
        n = len(matrix)
        for k in range(n): #upper triangle traversal
            for i, j in zip(range(0, k + 1), range(k,-1,-1)):
                result.append(matrix[i][j])
        for k in range(1, n): #lower triangle traversal
            for i, j in zip(range(k, n), range(n - 1, -1, -1)):
                result.append(matrix[i][j])
        return result
