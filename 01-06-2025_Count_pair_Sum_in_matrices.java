import java.util.*;

class Solution {
    public int countPairs(int[][] mat1, int[][] mat2, int x) {
        int count = 0;
        int n = mat1.length;
        Set<Integer> elements = new HashSet<>();

        // Insert all elements of mat2 into the HashSet
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                elements.add(mat2[i][j]);
            }
        }

        // Check if x - mat1[i][j] exists in mat2's elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                if (elements.contains(x - mat1[i][j])) {
                    count++;
                }
            }
        }

        return count;
    }
}
