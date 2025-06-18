class Solution {
    // Precompute all palindromic substrings in s
    public static void palindromes(String s, boolean[][] dp) {
        int n = s.length();

        // All single characters are palindromes
        for (int i = 0; i < n; ++i) dp[i][i] = true;

        // Check two-character substrings
        for (int i = 0; i < n - 1; ++i) dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));

        // Check substrings of length 3 or more using bottom-up DP
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }
    }

    // Recursive function to find all palindromic partitions
    public static void backtrack(int idx, String s, ArrayList<String> curr,
                                 ArrayList<ArrayList<String>> res, boolean[][] dp) {

        // If we have reached the end of the string, store current partition
        if (idx == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Try all substrings starting from index idx
        for (int i = idx; i < s.length(); ++i) {
            // If s[idx..i] is a palindrome, we can include it
            if (dp[idx][i]) {
                // Choose the substring
                curr.add(s.substring(idx, i + 1));
                // Explore further from next index
                backtrack(i + 1, s, curr, res, dp);
                // Undo the choice (backtrack)
                curr.remove(curr.size() - 1);
            }
        }
    }

    // Return all palindromic partitions of string s
    public static ArrayList<ArrayList<String>> palinParts(String s) {
        // DP table to store if substring s[i..j] is a palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];

        // Precompute all palindromic substrings using DP
        palindromes(s, dp);

        // Final result
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        // Current partition
        ArrayList<String> curr = new ArrayList<>();
        // Begin backtracking from index 0
        backtrack(0, s, curr, res, dp);
        return res;
    }
}