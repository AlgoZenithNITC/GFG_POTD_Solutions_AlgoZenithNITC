int min_operations(vector<int>& nums) {
        int n = nums.size(), maxi = 1;
        vector<int> dp(n, 1);
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] and (nums[i] - nums[j] >= (i - j))) {
                    dp[i] = max(1 + dp[j], dp[i]);
                    maxi = max(maxi, dp[i]);
                }
            }
        }
        
        return n - maxi;
    }
