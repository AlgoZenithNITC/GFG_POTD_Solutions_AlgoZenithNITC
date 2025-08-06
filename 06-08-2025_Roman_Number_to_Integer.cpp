class Solution {
public:
    int romanToDecimal(string s) {
        unordered_map<char, int> val = {
            {'I', 1}, {'V', 5}, {'X', 10},
            {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}
        };
        
        int total = 0;
        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && val[s[i]] < val[s[i + 1]]) {
                total += val[s[i + 1]] - val[s[i]];
                i += 2;
            } else {
                total += val[s[i]];
                i++;
            }
        }
        return total;
    }
};
