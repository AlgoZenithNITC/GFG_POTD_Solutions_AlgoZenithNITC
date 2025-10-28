def nearest(grid):
    n = len(grid)
    m = len(grid[0])

    ans = [[float('inf')] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):

            # if the cell has 1,
            # then the distance is 0
            if grid[i][j] == 1:
                ans[i][j] = 0
                continue

            # iterate over all the cells
            # and find the distance of the nearest 1
            for k in range(n):
                for l in range(m):
                    if grid[k][l] == 1:
                        ans[i][j] = min(ans[i][j],
                                        abs(i - k) + abs(j - l))
    return ans
