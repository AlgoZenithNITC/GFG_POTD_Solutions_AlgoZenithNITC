class Solution {
public:
    int lcsOf3(string& s1, string& s2, string& s3) {
        int n1 = s1.size(), n2 = s2.size(), n3 = s3.size();
        vector<vector<vector<int>>> dp(n1, vector<vector<int>>(n2, vector<int>(n3, -1)));
        return lc(s1, s2, s3, 0, 0, 0, dp);
    }

    int lc(string& s1, string& s2, string& s3, int n1, int n2, int n3,
           vector<vector<vector<int>>>& dp) {
        if (n1 >= s1.size() || n2 >= s2.size() || n3 >= s3.size()) return 0;

        if (dp[n1][n2][n3] != -1) return dp[n1][n2][n3];

        if (s1[n1] == s2[n2] && s2[n2] == s3[n3]) {
            return dp[n1][n2][n3] = 1 + lc(s1, s2, s3, n1 + 1, n2 + 1, n3 + 1, dp);
        }

        return dp[n1][n2][n3] = max({
            lc(s1, s2, s3, n1 + 1, n2, n3, dp),
            lc(s1, s2, s3, n1, n2 + 1, n3, dp),
            lc(s1, s2, s3, n1, n2, n3 + 1, dp)
        });
    }
};

