
class Solution {
  public:
  
    int v_cnt ;
    int e_cnt ;
    
    void dfs(vector<vector<int>> &adj , int i , vector<bool> &visited){
        visited[i]=true;
        v_cnt++;
        e_cnt+=adj[i].size();
        
        for(int next : adj[i]){
            if(!visited[next]){
                dfs(adj,next,visited);
            }
        }
    }
    
    int findNumberOfGoodComponent(int e, int v, vector<vector<int>> &edges) {
        // code here
      vector<bool> visited(v+1,false);
      vector<vector<int>> adj(v+1);
      for(int i=0;i<edges.size();i++){
          adj[edges[i][0]].push_back(edges[i][1]);
          adj[edges[i][1]].push_back(edges[i][0]);
      }
      int ans =0;
      
      for(int i=1;i<=v;i++){
          v_cnt=e_cnt=0;
          if(visited[i]==false){
              visited[i]=true;
              dfs(adj,i,visited);
             
              if(e_cnt==(v_cnt*(v_cnt-1))) ans++;
          }
      }
      return ans;
    }
};
