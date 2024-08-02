
class Solution {

    public int solve(int i, int j, String s1, String s2, int[][] memo) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (memo[i][j] != -1) return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j)) return solve(i - 1, j - 1, s1, s2, memo);

        int a = 1 + solve(i - 1, j, s1, s2, memo); // remove
        int b = 1 + solve(i, j - 1, s1, s2, memo); // insert
        int c = 1 + solve(i - 1, j - 1, s1, s2, memo); // replace

        memo[i][j] = Math.min(a, Math.min(b, c));
        return memo[i][j];
    }

    public int editDistance(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] memo = new int[n][m];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, m - 1, str1, str2, memo);
    }
}

