class Solution {
    
    public int count(int i, int j, int[][] matrix, int n, int m){
        int ans = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] == 1) { 
            ans++; 
        }
        if (i + 1 < n && matrix[i + 1][j] == 1) { 
            ans++; 
        }
        if (j - 1 >= 0 && matrix[i][j - 1] == 1) {
            ans++; 
        }
        if (j + 1 < m &&matrix[i][j + 1] == 1) { 
            ans++; 
        }
        return ans;
    }
    
    public int findCoverage(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    ans += count(i, j, matrix, n, m);
                }
            }
        }
        return ans;
    }
}
