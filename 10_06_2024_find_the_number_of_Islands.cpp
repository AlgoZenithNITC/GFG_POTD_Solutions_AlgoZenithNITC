class Solution {
  public:
  int n ,m ;
    // Function to find the number of islands.
    
  vector<int> dx = {-1,-1,0,1,1,1,0,-1};
  vector<int> dy = {0,1,1,1,0,-1,-1,-1};
    
    void dfs(int i , int j , vector<vector<char>> &grid , vector<vector<int>> &vis){
        vis[i][j]=1;
        
        for(int  k=0;k<8;k++){
            int nr = i+dx[k];
            int nc = j+dy[k];
            
            if(nr>=0 and nr<n and nc>=0 and nc<m and vis[nr][nc]==-1 and grid[nr][nc]=='1'){
                dfs(nr,nc,grid,vis);
            }
        }
        
    }
    
    
    
    int numIslands(vector<vector<char>>& grid) {
        // Code here
        n=grid.size();
        m=grid[0].size();
        vector<vector<int>> vis(n,vector<int>(m,-1));
        
        int ans =0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==-1 and grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        
        return ans ;
    }
};
