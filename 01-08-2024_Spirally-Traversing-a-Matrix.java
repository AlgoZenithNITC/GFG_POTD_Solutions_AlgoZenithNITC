class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        int r = matrix.length;
        int c = matrix[0].length;
        ArrayList<Integer> output = new ArrayList<Integer>();
        int row = 0;
        int col = 0;

        while (row < r && col < c) {
            // storing the elements of 1st row from the remaining rows, in a list.
            for (int i = col; i < c; i++) output.add(matrix[row][i]);
            row++;

            // storing elements of last column from remaining columns, in list.
            for (int i = row; i < r; i++) output.add(matrix[i][c - 1]);
            c--;

            // storing the elements of last row from remaining rows, in a list.
            if (row < r) {
                for (int i = c - 1; i >= col; --i) output.add(matrix[r - 1][i]);
                r--;
            }

            // storing elements of 1st column from the remaining columns, in list.
            if (col < c) {
                for (int i = r - 1; i >= row; --i) output.add(matrix[i][col]);
                col++;
            }
        }
        // returning the list.
        return output;
    }
}
