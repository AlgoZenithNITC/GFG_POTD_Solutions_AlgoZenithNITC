class Solution{   
    public:
    vector<int> sumTriangles(const vector<vector<int>>& matrix, int n){
        int upper_sum = 0, lower_sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i <= j){
                    upper_sum += matrix[i][j];
                }
                if(i >= j){
                    lower_sum += matrix[i][j];
                }
            }
        }
        return {upper_sum, lower_sum};
    }
};
