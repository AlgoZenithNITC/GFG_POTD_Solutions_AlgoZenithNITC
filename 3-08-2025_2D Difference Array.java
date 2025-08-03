 int n = mat.length;
        int m = mat[0].length;
        int[][] diff = new int[n + 2][m + 2];

        for (int[] op : opr) {
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

        // Create result as ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(mat[i][j] + diff[i][j]);
            }
            result.add(row);
        }

        return result;