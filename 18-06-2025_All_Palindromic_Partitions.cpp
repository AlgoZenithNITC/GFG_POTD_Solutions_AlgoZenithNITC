class Solution {
  public:
    // Precompute all palindromic substrings in s
    void palindromes(const string& s, vector<vector<bool>>& dp) {
        int n = s.size();

        // All single characters are palindromes
        for (int i = 0; i < n; ++i)
            dp[i][i] = true;

        // Check two-character substrings
        for (int i = 0; i < n - 1; ++i)
            dp[i][i + 1] = (s[i] == s[i + 1]);

        // Check substrings of length 3 or more using bottom-up DP
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1];
            }
        }
    }

    // Recursive function to find all palindromic partitions
    void backtrack(int idx, const string& s, vector<string>& curr,
                   vector<vector<string>>& res, vector<vector<bool>>& dp) {

        // If we have reached the end of the string, store current partition
        if (idx == s.size()) {
            res.push_back(curr);
            return;
        }

        // Try all substrings starting from index idx
        for (int i = idx; i < s.size(); ++i) {
            // If s[idx..i] is a palindrome, we can include it
            if (dp[idx][i]) {
                // Choose the substring
                curr.push_back(s.substr(idx, i - idx + 1));
                // Explore further from next index
                backtrack(i + 1, s, curr, res, dp);
                // Undo the choice (backtrack)
                curr.pop_back();
            }
        }
    }

    // Return all palindromic partitions of string s
    vector<vector<string>> palinParts(string& s) {

        // DP table to store if substring s[i..j] is a palindrome
        vector<vector<bool>> dp(s.size() + 1, vector<bool>(s.size() + 1, false));

        // Precompute all palindromic substrings using DP
        palindromes(s, dp);

        // Final result
        vector<vector<string>> res;
        // Current partition
        vector<string> curr;
        // Begin backtracking from index 0
        backtrack(0, s, curr, res, dp);
        return res;
    }
};