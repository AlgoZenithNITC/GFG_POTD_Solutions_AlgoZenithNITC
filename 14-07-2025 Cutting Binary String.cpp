class Solution {
  public:
    int cuts(string s) {
        if (s[0] == '0')
            return -1;
        int n = s.size();

        const int maxi = n + 1;
        unordered_set<int> powersOf5;

        // store power of 5
        int val = 1;
        while (val <= 1e9) {
            powersOf5.insert(val);
            val *= 5;
        }

        vector<int> dp(n + 1, maxi);

        // base case empty suffix requires 0 cuts
        dp[n] = 0;

        for (int i = n - 1; i >= 0; --i) {

            // ensure there is no leading '0'
            if (s[i] == '0')
                continue;

            int num = 0;
            for (int j = i; j < n; ++j) {
                num = num * 2 + (s[j] == '1');

                // and the number is a power of 5
                if (powersOf5.count(num)) {
                    if (dp[j + 1] != maxi) {
                        dp[i] = min(dp[i], 1 + dp[j + 1]);
                    }
                }
            }
        }

        return dp[0] >= maxi ? -1 : dp[0];
    }
};
