class Solution:
    # Function to return a list of integers denoting spiral traversal of matrix.
    def spirallyTraverse(self, matrix):
        r = len(matrix)
        c = len(matrix[0])
        output = []

        row = 0
        col = 0

        while row < r and col < c:
            # storing the elements of 1st row from the remaining rows, in a list.
            for i in range(col, c):
                output.append(matrix[row][i])
            row += 1

            # storing elements of last column from remaining columns, in list.
            for i in range(row, r):
                output.append(matrix[i][c - 1])
            c -= 1

            # storing the elements of last row from remaining rows, in a list.
            if row < r:
                for i in range(c - 1, col - 1, -1):
                    output.append(matrix[r - 1][i])
                r -= 1

            # storing elements of 1st column from the remaining columns, in list.
            if col < c:
                for i in range(r - 1, row - 1, -1):
                    output.append(matrix[i][col])
                col += 1

        # returning the list.
        return output
