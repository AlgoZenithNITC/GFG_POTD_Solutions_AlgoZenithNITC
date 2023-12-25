class Solution{
    static void cofactor(int matrix[][], int temp[][], int R, int C, int n) {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != R && col != C) {
                    temp[i][j] = matrix[row][col];
                    j++;
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    static int determinantOfMatrix(int matrix[][], int n){
        int ans = 0;
        if (n == 1) {
            return matrix[0][0];
        }
        int [][] temp = new int[n][n];
        int sign = 1;
        for(int i = 0; i < n; i++){
            cofactor(matrix, temp, 0, i, n);
            ans += sign*matrix[0][i]*determinantOfMatrix(temp, n - 1);
            sign *= -1;
        }
        return ans;
    }
}
