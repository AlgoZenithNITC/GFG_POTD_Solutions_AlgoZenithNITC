class Solution {
  public:
    int getLongestPrefix(string &s) {
        int n = s.size();
        if (n <= 1) return -1;
        vector<int> lps(n, 0);
        for (int i = 1, len = 0; i < n; ) {
            if (s[i] == s[len]) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        int b = lps[n - 1];      
        if (b == 0) return -1;  
        while (b > 0 && lps[b - 1] > 0) {
            b = lps[b - 1];
        }
        return n - b;
    }
};
