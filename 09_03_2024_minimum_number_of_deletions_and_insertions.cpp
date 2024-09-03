class Solution{
		

	public:
	
	int solve(int i, int j , string &str1 , string &str2 , vector<vector<int>> &memo){
	    
	    if(i>=str1.size() || j>=str2.size()) return 0;
	    
	    if(memo[i][j]!=-1) return memo[i][j];
	    
	    int a = 0;
	    if(str1[i]==str2[j])
	    a=1+solve(i+1,j+1,str1,str2,memo);
	    
	    int b=0,c=0;
	    if(str1[i]!=str2[j]){
	     
	        b = solve(i+1,j,str1,str2,memo);
	        c = solve(i,j+1,str1,str2,memo);
	    }
	    
	    return memo[i][j]=max(a,max(b,c));
	}
	
	
	int minOperations(string str1, string str2) 
	{ 
	    vector<vector<int>> memo(str1.size(),vector<int>(str2.size(),-1));
	    int lcs = solve(0,0,str1,str2,memo);
	    
	    return (str1.size()-lcs) + (str2.size()-lcs);
	} 
};
