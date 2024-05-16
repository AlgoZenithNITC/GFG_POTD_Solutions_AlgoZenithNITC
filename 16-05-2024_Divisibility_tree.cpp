class Solution {
public:
    int ans=0; //declare globally
    
    int dfs(int start,vector<vector<int>>&adj,vector<int>&visited){
         int count=0; //storing size of subtree
         int result=0;
         visited[start]=1;
         for(auto it: adj[start]){
             if(!visited[it]){
                 result= dfs(it,adj,visited);  //result is storing size of subtree
                 if(result%2==0){
                     ans++;
                 }
                 else{
                     count+=result;
                 }
             }
         }
         return count+1;
    }


	int minimumEdgeRemove(int n, vector<vector<int>>edges){
	    vector<vector<int>>adj(n+1);
	    vector<int>visited(n,0);
	
	    for(auto edge: edges){
	        int u=edge[0];
	        int v=edge[1];
	        adj[u-1].push_back(v-1);
	        adj[v-1].push_back(u-1);
	    }
	   
	    dfs(0,adj,visited);
	    return ans;
	}
};
