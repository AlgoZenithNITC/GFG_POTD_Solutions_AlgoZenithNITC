class Solution {
public:
    vector<vector<int>> applyDiff2D(vector<vector<int>>& mat,
                                    vector<vector<int>>& opr) {
        int n = mat.size();
        int m = mat[0].size();
        vector<vector<int>> diff(n + 2, vector<int>(m + 2, 0));
        
        for (auto& op : opr) {
            int val = op[0];
            int x1 = op[1], y1 = op[2], x2 = op[3], y2 = op[4];

            diff[x1][y1] += val;
            diff[x2 + 1][y1] -= val;
            diff[x1][y2 + 1] -= val;
            diff[x2 + 1][y2 + 1] += val;
        }

        // Apply 2D prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) diff[i][j] += diff[i - 1][j];
                if (j > 0) diff[i][j] += diff[i][j - 1];
                if (i > 0 && j > 0) diff[i][j] -= diff[i - 1][j - 1];
            }
        }

        // Apply result to original matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                mat[i][j] += diff[i][j];

        return mat;
    }
};
