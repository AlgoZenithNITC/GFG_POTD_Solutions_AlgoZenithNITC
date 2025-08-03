class Solution:
    def applyDiff2D(self, mat, opr):
        # code here 
        n, m = len(mat), len(mat[0])
        diff = [[0] * (m + 2) for _ in range(n + 2)]

        for op in opr:
            val, x1, y1, x2, y2 = op
            diff[x1][y1] += val
            diff[x2 + 1][y1] -= val
            diff[x1][y2 + 1] -= val
            diff[x2 + 1][y2 + 1] += val

        # Apply 2D prefix sum
        for i in range(n):
            for j in range(m):
                if i > 0:
                    diff[i][j] += diff[i - 1][j]
                if j > 0:
                    diff[i][j] += diff[i][j - 1]
                if i > 0 and j > 0:
                    diff[i][j] -= diff[i - 1][j - 1]

        # Apply the result to the original matrix
        for i in range(n):
            for j in range(m):
                mat[i][j] += diff[i][j]

        return mat