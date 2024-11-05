import java.util.List;

public class Solution {
    public void rotate(List<List<Integer>> matrix) {
        int m = matrix.size();
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, temp);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(i).get(m - j - 1));
                matrix.get(i).set(m - j - 1, temp);
            }
        }
    }
}


