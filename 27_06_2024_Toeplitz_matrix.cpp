bool ok(vector<vector<int>>& mat, int i, int j, int n, int m) {
    int res = mat[i][j];
    // Loop through the diagonal line and check if elements are equal
    while (++i < n && ++j < m) {
        if (mat[i][j] != res)
            return false;
    }
    // Return true if all elements in the diagonal line are equal
    return true;
}

bool isToepliz(vector<vector<int>>& mat) {
    // Check all diagonal lines starting from the top row
    int n = mat.size();
    int m = mat[0].size();
    for (int i = 0; i < m; i++) {
        // If any diagonal line is not equal, return false
        if (!ok(mat, 0, i, n, m))
            return false;
    }

    // Check all diagonal lines starting from the first column (excluding the top row)
    for (int i = 1; i < n; i++) {
        // If any diagonal line is not equal, return false
        if (!ok(mat, i, 0, n, m))
            return false;
    }

    // Return true if all diagonal lines are equal
    return true;
}
