class Solution{
	public int maxSumIS(int arr[], int n){  
	    int dp[] = new int[n];
	    System.arraycopy(arr, 0, dp, 0, n);
	    int ans = dp[0];
	    for(int i = 1; i < n; i++){
	        for(int j = i - 1; j >= 0; j--){
	            if(arr[j] < arr[i]){
	                dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
	    }
	    return ans;
	}  
}
