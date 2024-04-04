class Solution
{
    public static long sumSubstrings(String s)
    {
     int n = s.length(), mod = (int)1e9 + 7;
        long dp[] = new long[n];
        dp[0] = s.charAt(0) - '0';
        long res = dp[0];
        for(int i = 1; i < n; i++) 
        {
            dp[i] = ((dp[i - 1] * 10) % mod + ((s.charAt(i) - '0') * (i + 1)) % mod) % mod;
            res = (res + dp[i]) % mod;
        }
        return res % mod;
    }
}
