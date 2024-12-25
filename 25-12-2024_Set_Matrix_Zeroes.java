class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int c0 = 1;
        int rows = mat.length, cols = mat[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    if (j == 0) {
                        c0 = 0;
                    } else {
                        mat[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if (mat[0][0] == 0) {
            for (int j = 0; j < cols; ++j) {
                mat[0][j] = 0;
            }
        }

        if (c0 == 0) {
            for (int i = 0; i < rows; ++i) {
                mat[i][0] = 0;
            }
        }
    }
}
