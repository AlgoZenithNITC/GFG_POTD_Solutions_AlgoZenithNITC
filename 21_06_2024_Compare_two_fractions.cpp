class Solution {
  public:
    // Function to compare two fractions.
    string compareFrac(string str) {

        // Initializing numerator and denominator variables.
        int a, b, c, d;
        a = b = c = d = 0;

        // Regular expression to match and extract numerical values from string.
        regex re("([0-9]+)\\/([0-9]+), ([0-9]+)\\/([0-9]+)",
                 regex_constants::ECMAScript);
        smatch sm;

        // Matching and extracting values using regex.
        if (regex_search(str, sm, re)) {

            a = stoi(sm[1]);
            b = stoi(sm[2]);
            c = stoi(sm[3]);
            d = stoi(sm[4]);
        }

        // Variable to store the comparison result.
        string ans = "";

        // Comparing fractions and updating the result variable accordingly.
        if (a * d > b * c) {
            ans += to_string(a);
            ans += "/";
            ans += to_string(b);
        } else if (b * c > a * d) {
            ans += to_string(c);
            ans += "/";
            ans += to_string(d);
        } else {
            ans = "equal";
        }

        // Returning the result.
        return ans;
    }
};
