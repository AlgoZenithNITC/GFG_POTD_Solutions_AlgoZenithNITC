class Solution:

    def setMatrixZeroes(self, mat):
        n = len(mat)
        m = len(mat[0])

        c0 = 1

        # Traverse the arr and mark first
        # cell of each row and column
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:

                    # mark i-th row
                    mat[i][0] = 0

                    # mark j-th column
                    if j == 0:
                        c0 = 0
                    else:
                        mat[0][j] = 0

        # Traverse and mark the matrix from
        # (1, 1) to (n - 1, m - 1)
        for i in range(1, n):
            for j in range(1, m):

                # Check for col & row
                if mat[i][0] == 0 or mat[0][j] == 0:
                    mat[i][j] = 0

        # Mark the first row
        if mat[0][0] == 0:
            for j in range(m):
                mat[0][j] = 0

        # Mark the first column
        if c0 == 0:
            for i in range(n):
                mat[i][0] = 0
