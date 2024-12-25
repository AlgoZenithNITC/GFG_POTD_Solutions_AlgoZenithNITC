class Solution:
    def setMatrixZeroes(self, mat):
        c0 = 1
        rows, cols = len(mat), len(mat[0])
        
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    mat[i][0] = 0
                    if j == 0:
                        c0 = 0
                    else:
                        mat[0][j] = 0
        
        for i in range(1, rows):
            for j in range(1, cols):
                if mat[i][0] == 0 or mat[0][j] == 0:
                    mat[i][j] = 0
        
        if mat[0][0] == 0:
            for j in range(cols):
                mat[0][j] = 0
        
        if c0 == 0:
            for i in range(rows):
                mat[i][0] = 0
