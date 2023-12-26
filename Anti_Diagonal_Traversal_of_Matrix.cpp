class Solution {
  public:
    vector<int> antiDiagonalPattern(vector<vector<int>> matrix){
        vector<int> result;
        int n = matrix.size();
        for(int i = 0; i < n; i++){
            int row = 0, col = i;
            while(row < n and col >= 0){
                result.push_back(matrix[row++][col--]);
            }
        }
        for(int i = 1; i < n; i++){
            int row = i, col = n - 1;
            while(row < n and col >= 0){
                result.push_back(matrix[row++][col--]);
            }
        }
        return result;
    }
};
