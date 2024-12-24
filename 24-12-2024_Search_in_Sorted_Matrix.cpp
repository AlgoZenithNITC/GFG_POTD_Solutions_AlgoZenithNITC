class Solution {
  public:
  
    bool searchMatrix(vector<vector<int>> &mat, int x) {
        int n = mat.size();
        int m = mat[0].size();
        
        
        int lo = 0, hi = n * m - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
          
            int row = mid / m;
            int col = mid % m;
          
            if (mat[row][col] == x) 
                return true;
          
            if (mat[row][col] < x) 
                lo = mid + 1;
            
            else 
                hi = mid - 1;
        }
        return false;
    }
};
