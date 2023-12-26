class Solution{
    public int[] antiDiagonalPattern(int[][] matrix){
        int n = matrix.length;
        int [] result = new int[n*n];
        int pos = 0;
        for(int i = 0; i < n; i++){  //Upper triangle traversal
            int row = 0, col = i;
            while(col >= 0){
                result[pos++] = matrix[row][col];
                row++;
                col--;
            }
        }
        for(int i = 1; i < n; i++){ //Lower triangle traversal
            int row = i, col = n - 1;
            while(row < n){
                result[pos++] = matrix[row][col];
                row++;
                col--;
            }
        }
        return result;
    }
}
