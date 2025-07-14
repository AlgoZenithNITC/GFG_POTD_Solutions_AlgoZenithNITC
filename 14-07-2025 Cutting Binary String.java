class Solution {
    public int cuts(String s) {
        if (s.charAt(0) == '0') return -1;

        int n = s.length();
        int maxi = n + 1;
        Set<Integer> powersOf5 = new HashSet<>();

        // store power of 5
        int val = 1;
        while (val <= 1_000_000_000) {
            powersOf5.add(val);
            val *= 5;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, maxi);

        // base case empty suffix requires 0 cuts
        dp[n] = 0;

        for (int i = n - 1; i >= 0; --i) {

            // ensure there is no leading '0'
            if (s.charAt(i) == '0') continue;

            int num = 0;
            for (int j = i; j < n; ++j) {
                num = num * 2 + (s.charAt(j) == '1' ? 1 : 0);

                // and the number is a power of 5
                if (powersOf5.contains(num)) {
                    if (dp[j + 1] != maxi) {
                        dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                    }
                }
            }
        }

        return dp[0] >= maxi ? -1 : dp[0];
    }
}
