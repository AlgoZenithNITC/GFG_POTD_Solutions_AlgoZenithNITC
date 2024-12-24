class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;    
        int m = mat[0].length; 

        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mid_value = mat[mid / m][mid % m]; 

            if (mid_value == x) {
                return true; 
            } else if (mid_value < x) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return false;
    }
}
