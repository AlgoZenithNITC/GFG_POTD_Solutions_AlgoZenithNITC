class Solution{
    static int palindromicPartition(String str){
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], true);
        }
        for(int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                dp[i][j] = (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]);
            }
        }
        int[] cuts = new int[n + 1];
        Arrays.fill(cuts, n - 1);
        cuts[0] = -1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(dp[j - 1][i - 1]) {
                    cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                }
            }
        }
        return cuts[n];
    }
}
