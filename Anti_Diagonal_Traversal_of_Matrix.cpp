class Solution {
  public:
    vector<int> antiDiagonalPattern(vector<vector<int>> matrix){
        vector<vector<int>> result(matrix.size() + matrix[0].size());
        for(int i = 0; i < matrix.size(); ++i){
            for(int j = 0; j < matrix[0].size(); ++j){
                result[i + j].push_back(matrix[i][j]);
            }
        }
        return result;
    }
};
