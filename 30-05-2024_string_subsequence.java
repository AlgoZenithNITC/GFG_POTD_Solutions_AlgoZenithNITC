

class Solution {
    public static final int MOD = (int) 1e9 + 7;

    public static int solve(int i, int j, String s1, String s2, int[][] memo) {
        if (j >= s2.length()) return 1;
        if (i >= s1.length()) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int ans = solve(i + 1, j, s1, s2, memo) % MOD;

        if (s1.charAt(i) == s2.charAt(j)) {
            ans = (ans + solve(i + 1, j + 1, s1, s2, memo)) % MOD;
        }

        return memo[i][j] = ans % MOD;
    }

    public static int countWays(String s1, String s2) {
        int[][] memo = new int[s1.length()][s2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s1, s2, memo);
    }
}
