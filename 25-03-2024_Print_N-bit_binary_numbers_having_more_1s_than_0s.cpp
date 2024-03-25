class Solution{
public:	

    void generate(int n, string s, int ones, int zeroes, vector<string>& ans){
        if(s.length() == n){
            ans.push_back(s);
            return;
        }
        generate(n, s + "1", ones + 1, zeroes, ans);
        
        if(ones > zeroes){
            generate(n, s + "0", ones, zeroes + 1, ans);
        }
    }

	vector<string> NBitBinary(int n)
	{
	    // Your code goes here
	    vector<string> ans;
	    generate(n, "", 0, 0, ans);
	    
	    return ans;
	}
};
