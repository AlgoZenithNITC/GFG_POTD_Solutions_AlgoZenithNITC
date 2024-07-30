vector<vector<int>> visited(5, vector<int>(5, 0));
class Solution {
    public:
    
    vector<string>ans;
    void dfs(vector<vector<int>>&mat, int x, int y, string dir, int n){
        if(x == n-1 and y == n-1){
            ans.push_back(dir);
            return;
        }
        
        if(mat[x][y] == 0 or visited[x][y] == 1) return;
        
        visited[x][y] = 1;
        
        if(x > 0){
            dfs(mat, x-1, y, dir+'U', n);
        }
        if(y > 0){
            dfs(mat, x, y-1, dir+'L', n);
        }
        if(x < n-1){
            dfs(mat, x+1, y, dir+'D', n);
        }
        if(y < n-1){
            dfs(mat, x, y+1, dir+'R', n);
        }
        visited[x][y] = 0;
    }
    
    vector<string> findPath(vector<vector<int>> &mat) {
        int n = mat.size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = 0;
            }
        }
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0)
            return ans;
        dfs(mat, 0, 0, "", n);
        sort(ans.begin(), ans.end());
        return ans;
    }
};
