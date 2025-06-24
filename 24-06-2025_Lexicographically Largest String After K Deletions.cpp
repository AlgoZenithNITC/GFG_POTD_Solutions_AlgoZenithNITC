class Solution {
  public:
    string maxSubseq(string &s, int k) {
        int n = s.length();

        // Keep original k untouched
        int toRemove = k;
        string res = "";

        for (int i = 0; i < n; i++) {

            // Remove smaller characters from the end if we still have quota
            while (!res.empty() && toRemove > 0 && res.back() < s[i]) {
                res.pop_back();
                toRemove--;
            }
            res.push_back(s[i]);
        }

        // The required length is n - k, so slice accordingly
        res.resize(n - k);
        return res;
    }
};