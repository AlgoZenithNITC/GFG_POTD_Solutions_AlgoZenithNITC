#include <string>
#include <unordered_map>
#include <algorithm>

class Solution {
public:
    int longestUniqueSubstr(const std::string& s) {
        int maxLength = 0; // To store the length of the longest substring
        std::string currentSubstring = "";

        for (char c : s) {
            size_t pos = currentSubstring.find(c);

            if (pos == std::string::npos) {
                currentSubstring += c;
                maxLength = std::max(maxLength, static_cast<int>(currentSubstring.length()));
            } else {
                currentSubstring = currentSubstring.substr(pos + 1) + c;
            }
        }

        return maxLength;
    }
};
