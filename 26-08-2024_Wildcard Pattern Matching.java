class Solution {
    
    public int solve(int i, int j, String s, String t) {
        if (i <= 0 && j <= 0) {
            return 1;
        }
        if (j <= 0) {
            while (i > 0 && s.charAt(i - 1) == '*') {
                i--;
            }
            return i <= 0 ? 1 : 0;
        }
        
        
        if (i <= 0 || j <= 0) {
            return 0;
        }

        int a = 0;
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            a = solve(i - 1, j - 1, s, t);
        } else if (s.charAt(i - 1) == '?') {
            a = solve(i - 1, j - 1, s, t);
        } else if (s.charAt(i - 1) == '*') {
            a = solve(i - 1, j - 1, s, t) | solve(i, j - 1, s, t) | solve(i - 1, j, s, t);
        }
        return a;
    }
    
    public int wildCard(String pattern, String str) {
        // Your code goes here
        int n = pattern.length();
        int m = str.length();
        return solve(n, m, pattern, str);
    }
}
