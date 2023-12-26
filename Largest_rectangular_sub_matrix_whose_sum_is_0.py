class Solution:
  def findSum(self, r1, c1, r2, c2, n, m, pref):
    sum = pref[r2][c2]
    if (c1 - 1) >= 0:
        sum -= pref[r2][c1 - 1]
    if (r1 - 1) >= 0:
        sum -= pref[r1 - 1][c2]
    if (c1 - 1) >= 0 and (r1 - 1) >= 0:
        sum += pref[r1 - 1][c1 - 1]
    return sum
  def sumZeroMatrix(self, a : List[List[int]]) -> List[List[int]]:
    n = len(a)
    m = len(a[0])
    pref = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            pref[i][j] = a[i][j]
            if (j - 1) >= 0:
                pref[i][j] += pref[i][j - 1]
    for j in range(m):
        for i in range(n):
            if (i - 1) >= 0:
                pref[i][j] += pref[i - 1][j]
    ans = 0
    sub_matrix = [0, 0, 0, 0]
    for r1 in range(n):
        for c1 in range(m):
            for r2 in range(r1, n):
                for c2 in range(c1, m):
                    sum = self.findSum(r1, c1, r2, c2, n, m, pref)
                    if sum == 0:
                        submatrixSize = (r2 - r1 + 1) * (c2 - c1 + 1)
                        if submatrixSize > ans:
                            ans = submatrixSize
                            sub_matrix = [r1, r2, c1, c2]
                        elif submatrixSize == ans:
                            if c1 < sub_matrix[2]:
                                sub_matrix = [r1, r2, c1, c2]
                            elif c1 == sub_matrix[2] and r2 - r1 + 1 > sub_matrix[1] - sub_matrix[0] + 1:
                                sub_matrix = [r1, r2, c1, c2]
                            elif c1 == sub_matrix[2] and r2 - r1 + 1 == sub_matrix[1] - sub_matrix[0] + 1 and r1 < sub_matrix[0]:
                                sub_matrix = [r1, r2, c1, c2]
    if ans == 0:
        result = [[]]
        return result
    first_row = sub_matrix[0]
    last_row = sub_matrix[1]
    first_col = sub_matrix[2]
    last_col = sub_matrix[3]
    ans_mat = [[0] * (last_col - first_col + 1) for _ in range(last_row - first_row + 1)]
    for i in range(first_row, last_row + 1):
        for j in range(first_col, last_col + 1):
            ans_mat[i - first_row][j - first_col] = a[i][j]
    return ans_mat
