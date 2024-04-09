int minPoints(int n, int m, vector<vector<int>> points) { 
	    
	    vector<vector<int>>dp(n, vector<int>(m,0));
	    for(int i = n-1; i>=0; i--){
	        for(int j = m-1; j>=0; j--){
	            
	            if(i == n-1 && j==m-1){
	                dp[i][j] = min(0,points[i][j]);
	                continue;
	            }
	            
	            int right = -1e9;
	            int down = -1e9;
	            if(j+1<m) right = dp[i][j+1];
	            if(i+1<n) down = dp[i+1][j];
	            dp[i][j] = points[i][j] + max(down,right);
	            dp[i][j] = min(0,dp[i][j]);
	        }
	    }
	    return abs(dp[0][0])+1;
	    
	} 
