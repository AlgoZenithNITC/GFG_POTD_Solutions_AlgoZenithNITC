def rotate(matrix):
    m = len(matrix)
    for i in range(m):
        for j in range(i, m):
            temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
    for i in range(m):
        for j in range(m // 2):
            temp = matrix[i][j]
            matrix[i][j] = matrix[i][m - j - 1]
            matrix[i][m - j - 1] = temp


