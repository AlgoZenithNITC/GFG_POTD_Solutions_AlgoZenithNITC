def search_row_matrix(mat, n, m, x):
    for i in range(n):
        l, r = 0, m - 1
        while l <= r:
            mid = (l + r) // 2
            if mat[i][mid] == x:
                return True
            elif mat[i][mid] > x:
                r = mid - 1
            else:
                l = mid + 1
    return False
