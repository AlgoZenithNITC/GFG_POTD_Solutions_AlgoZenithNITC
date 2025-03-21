class Solution {
  public:
    int findMaxSum(vector<int>& arr) {
      


    int n = arr.size();
    
    // Handle base cases
    if (n == 0) return 0;
    if (n == 1) return arr[0];
    
    // dp array to store the maximum loot up to each house
    vector<int> dp(n, 0);
    
    // Base cases
    dp[0] = arr[0];
    dp[1] = max(arr[0], arr[1]);
    
    // Fill the dp array for each house from index 2 to n-1
    for (int i = 2; i < n; i++) {
        dp[i] = max(dp[i-1], arr[i] + dp[i-2]);
    }
    
    // The last element in dp will have the maximum loot
    return dp[n-1];
}
};
