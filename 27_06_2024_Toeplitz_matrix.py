def isToepliz(mat):
    # Function to check if matrix is a Toepliz matrix
    n = len(mat)
    m = len(mat[0])

    if (m == 1):
        return True

    # Checking each element of the matrix except for the first row and first column
    for i in range(1, n):
        for j in range(1, m):
            # If any element is not equal to the element diagonally before it, return False
            if (mat[i - 1][j - 1] != mat[i][j]):
                return False

    return True
