class Solution {
    public:
    
    int count(int i, int j, vector<vector<int>>& matrix, int n, int m){
        int cnt = 0;
        if(i+1 < n && matrix[i+1][j] == 1){
            cnt++;
        }
        if(j+1 < m && matrix[i][j+1] == 1){
            cnt++;
        }
        if(i-1 >= 0 && matrix[i-1][j] == 1){
            cnt++;
        }
        if(j-1 >= 0 && matrix[i][j-1] == 1){
            cnt++;
        }
        return cnt;
    }
    
    int findCoverage(vector<vector<int>>& matrix) {
        int ans = 0;
        int n = matrix.size(), m = matrix[0].size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    ans += count(i, j, matrix, n, m);
                }
            }
        }
        return ans;
    }
};
