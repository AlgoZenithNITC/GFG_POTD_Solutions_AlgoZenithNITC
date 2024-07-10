class Solution {
    public int maxSquare(int n, int m, int[][] mat) {
        int[] prev = new int[m];
        int[] curr = new int[m];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            prev[i] = mat[0][i];
            ans = Math.max(ans, prev[i]);
        }

        for (int i = 1; i < n; i++) {
            curr[0] = mat[i][0];
            ans = Math.max(ans, curr[0]);
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    curr[j] = 0;
                    continue;
                }
                curr[j] = 1 + Math.min(prev[j], Math.min(curr[j - 1], prev[j - 1]));
                ans = Math.max(ans, curr[j]);
            }
            prev = curr.clone();
        }

        return ans;
    }
