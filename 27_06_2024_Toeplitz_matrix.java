class Solution {
    // function to check if all elements in a diagonal line starting from a given
    // element are equal
    boolean ok(int mat[][], int i, int j, int n, int m) {
        int res = mat[i][j];
        // loop through the diagonal line and check if elements are equal
        while (++i < n && ++j < m) {
            if (mat[i][j] != res) return false;
        }
        // return true if all elements in the diagonal line are equal
        return true;
    }

    boolean isToepliz(int mat[][]) {
        // check all diagonal lines starting from the top row
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < m; i++) {
            // if any diagonal line is not equal, return false
            if (!ok(mat, 0, i, n, m)) return false;
        }

        // check all diagonal lines starting from the first column (excluding the top
        // row)
        for (int i = 1; i < n; i++) {
            // if any diagonal line is not equal, return false
            if (!ok(mat, i, 0, n, m)) return false;
        }

        // return true if all diagonal lines are equal
        return true;
    }
}
