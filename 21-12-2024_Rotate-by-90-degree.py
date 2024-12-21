class Solution:
    
    #Function to rotate matrix anticlockwise by 90 degrees.
    def rotateby90(self, mat): 
        n = len(mat)
        
        # Step 1: Transpose the matrix
        for i in range(n):
            for j in range(i, n):
                mat[i][j], mat[j][i] = mat[j][i], mat[i][j]
        
        # Step 2: Reverse the columns
        for i in range(n):
            for j in range(n // 2):
                mat[j][i], mat[n - j - 1][i] = mat[n - j - 1][i], mat[j][i]
