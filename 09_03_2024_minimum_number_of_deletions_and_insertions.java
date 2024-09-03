
class Solution {

    public int solve(int i, int j, String str1, String str2, int[][] memo) {
        
        if (i >= str1.length() || j >= str2.length()) return 0;
        
        if (memo[i][j] != -1) return memo[i][j];
        
        int a = 0;
        if (str1.charAt(i) == str2.charAt(j))
            a = 1 + solve(i + 1, j + 1, str1, str2, memo);
        
        int b = 0, c = 0;
        if (str1.charAt(i) != str2.charAt(j)) {
            b = solve(i + 1, j, str1, str2, memo);
            c = solve(i, j + 1, str1, str2, memo);
        }
        
        return memo[i][j] = Math.max(a, Math.max(b, c));
    }

    public int minOperations(String str1, String str2) {
        int[][] memo = new int[str1.length()][str2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int lcs = solve(0, 0, str1, str2, memo);
        
        return (str1.length() - lcs) + (str2.length() - lcs);
    }
}
