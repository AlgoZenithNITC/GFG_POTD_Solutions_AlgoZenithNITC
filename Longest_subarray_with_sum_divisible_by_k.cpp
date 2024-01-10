class Solution{
public:	
	int longSubarrWthSumDivByK(int arr[], int n, int k){
	    int ans = 0;
	    vector<int> store(k, -1);
	    int rem = 0;
	    for(int i = 0; i < n; i += 1){
	        rem = (rem + arr[i]%k + k)%k;
	        if(rem == 0){
	            ans = max(ans, i + 1);
	        }else if(store[rem] == -1){
	            store[rem] = i;
	        }else{
	            ans = max(ans, i - store[rem]);
	        }
	    }
	    return ans;
	}
};
