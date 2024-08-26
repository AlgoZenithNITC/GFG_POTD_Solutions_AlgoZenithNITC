class Solution {
  public:
  
    int solve(int i, int j, string &s, string &t) {
        if (i <= 0 && j <= 0) {
            return 1;
        }
        if (j <= 0) {
            while(i >= 0 && s[i - 1] == '*') {
                i--;
            }
            return i <= 0;
        }
        if (i <= 0 || j <= 0) {
            return 0;
        }

        int a = 0;
        if (s[i - 1] == t[j - 1]) {
            a = solve(i - 1, j - 1, s, t);
        } else if (s[i - 1] == '?') {
            a = solve(i - 1, j - 1, s, t);
        } else if (s[i - 1] == '*') {
            a = solve(i - 1, j - 1, s, t) || solve(i, j - 1, s, t) || solve(i - 1, j, s, t);
        }
        return a;
    }
    
    /*You are required to complete this method*/
    int wildCard(string s, string t) {
        int n = s.size();
        int m = t.size();

        return solve(n, m, s, t);
    }
};
