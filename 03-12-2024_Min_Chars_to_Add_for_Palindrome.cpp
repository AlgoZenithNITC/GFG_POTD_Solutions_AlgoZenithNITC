class Solution {
  public:
     void reverseString(string &str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            swap(str[i], str[n - i - 1]);
        }
    }

    // Helper function to compute the LPS (Longest Prefix Suffix) array
    void computeLongestPrefixSuffix(const string &str, int len, vector<int> &lps) {
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < len) {
            if (str[i] == str[length]) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Function to find the minimum characters to add to make the string a palindrome
    int minChar(string &s) {
        int len = s.length();
        string revStr = s;
        reverseString(revStr); // Reverse the string

        // Concatenate original string, delimiter, and reversed string
        string concat = s + "|" + revStr;
        int concatLen = concat.length();
        vector<int> lps(concatLen, 0);

        // Compute the LPS array for the concatenated string
        computeLongestPrefixSuffix(concat, concatLen, lps);

        // Minimum characters to add = original length - LPS of concatenated string
        return len - lps[concatLen - 1];
    }
};
