class Solution{
public:	
	int longSubarrWthSumDivByK(int arr[], int n, int k){
	    int ans = 0;
	    unordered_map<int, int> mp;
	    int rem = 0;
	    for(int i = 0; i < n; i += 1){
	        rem = (rem + arr[i]%k + k)%k;
	        if(rem == 0){
	            ans = max(ans, i + 1);
	        }else if(mp.find(rem) == mp.end()){
	            mp[rem] = i;
	        }else{
	            ans = max(ans, i - mp[rem]);
	        }
	    }
	    return ans;
	}
};
