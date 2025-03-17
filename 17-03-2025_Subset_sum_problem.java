static Boolean isSubsetSum(int arr[], int sum) {
    // code here
    int n = arr.length;
    boolean[][] dp = new boolean[n + 1][sum + 1];

    for (int i = 0; i <= n; i++) {
        dp[i][0] = true; // Base case: sum = 0 is always possible with an empty subset
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sum; j++) {
            if (arr[i - 1] > j)
                dp[i][j] = dp[i - 1][j]; // Exclude the current element
            else
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]; // Include or exclude the element
        }
    }

    return dp[n][sum];
}
