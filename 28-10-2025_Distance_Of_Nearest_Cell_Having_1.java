class Solution {
  public:
    vector<vector<int>> nearest(vector<vector<int>>& grid) {
        int n = grid.length;
        int m = grid[0].length;

        ArrayList<ArrayList<Integer> > ans
            = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(Integer.MAX_VALUE);
            }
            ans.add(row);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans.get(i).set(j, 0);
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (grid[k][l] == 1) {
                            int distance
                                = Math.abs(i - k)
                                  + Math.abs(j - l);
                            if (distance
                                < ans.get(i).get(j)) {
                                ans.get(i).set(j, distance);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
};
