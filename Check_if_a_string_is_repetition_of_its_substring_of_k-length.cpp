class Solution{
public:
	int kSubstrConcat (int n, string str, int k){
	    if(n%k != 0){
	        return false;
	    }
	    unordered_map<string, int> mp;
	    for(int i = 0; i < n; i += k){
	        mp[str.substr(i, k)]++;
	    }
	    if(mp.size() == 1){
	        return true;
	    }
	    if(mp.size() != 2){
	        return false;
	    }
	    if((mp.begin() -> second == 1) or (mp.begin() -> second = (n/k - 1))){
	        return true;
	    }
	    return false;
    }
};
