import java.util.*;

class Solution {
    public boolean ValidCorner(int[][] mat) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int val : mat[i]) {
                if (val == 1) count++;
            }
            if (count >= 2) row.add(i);
        }

        for (int i = 0; i < row.size(); i++) {
            for (int j = i + 1; j < row.size(); j++) {
                int c = 0;
                for (int k = 0; k < mat[0].length; k++) {
                    if (mat[row.get(i)][k] == 1 && mat[row.get(j)][k] == 1) {
                        c++;
                        if (c == 2) return true;
                    }
                }
            }
        }

        return false;
    }
}