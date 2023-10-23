class Solution{
	public:
	int maxSumIS(int arr[], int n){  
	    vector<int> dp(arr, arr + n);
	    int ans = dp[0];
	    for(int i = 1; i < n; i++){
	        for(int j = i - 1; j >= 0; j--){
	            if(arr[j] < arr[i]){
	                dp[i] = max(dp[i], dp[j] + arr[i]);
	            }
	        }
	        ans = max(ans, dp[i]);
	    }
	    return ans;
	}  
};
