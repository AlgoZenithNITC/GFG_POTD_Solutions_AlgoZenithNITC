def matSearch(mat, x):
    n = len(mat)
    m = len(mat[0])
    i = 0
    j = m - 1

    while i < n and j >= 0:
      
        # If x > mat[i][j], then x will be greater
        # than all elements to the left of 
        # mat[i][j] in row i, so increment i
        if x > mat[i][j]:
            i += 1
      
        # If x < mat[i][j], then x will be smaller
        # than all elements to the bottom of
        # mat[i][j] in column j, so decrement j
        elif x < mat[i][j]:
            j -= 1
      
        # If x = mat[i][j], return true
        else:
            return True

    # If x was not found, return false
    return False

if __name__ == "__main__":
    mat = [
        [3, 30, 38],
        [20, 52, 54],
        [35, 60, 69]
    ]
    x = 35
    if matSearch(mat, x):
        print("true")
    else:
        print("false")