import java.util.Arrays;

class Solution {
    public int lcsOf3(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        int[][][] dp = new int[n1][n2][n3];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        return lc(s1, s2, s3, 0, 0, 0, dp);
    }

    private int lc(String s1, String s2, String s3, int n1, int n2, int n3, int[][][] dp) {
        if (n1 >= s1.length() || n2 >= s2.length() || n3 >= s3.length()) return 0;

        if (dp[n1][n2][n3] != -1) return dp[n1][n2][n3];

        if (s1.charAt(n1) == s2.charAt(n2) && s2.charAt(n2) == s3.charAt(n3)) {
            return dp[n1][n2][n3] = 1 + lc(s1, s2, s3, n1 + 1, n2 + 1, n3 + 1, dp);
        }

        return dp[n1][n2][n3] = Math.max(Math.max(
            lc(s1, s2, s3, n1 + 1, n2, n3, dp),
            lc(s1, s2, s3, n1, n2 + 1, n3, dp)),
            lc(s1, s2, s3, n1, n2, n3 + 1, dp)
        );
    }
}


