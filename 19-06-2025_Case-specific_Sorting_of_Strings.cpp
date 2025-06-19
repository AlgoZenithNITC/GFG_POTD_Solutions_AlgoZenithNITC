class Solution {
public:
    string caseSort(string s) {
        string lower, upper;
        for (char c : s) {
            if (islower(c)) lower += c;
            else upper += c;
        }
        
        sort(lower.begin(), lower.end());
        sort(upper.begin(), upper.end());

        string result = "";
        int i = 0, j = 0;
        for (char c : s) {
            if (islower(c)) {
                result += lower[i++];
            } else {
                result += upper[j++];
            }
        }
        return result;
    }
};
