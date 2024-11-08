#include <string>
using namespace std;

class Solution {
public:
    int minRepeats(string s1, string s2) {
        int minRepeats = (s2.length() + s1.length() - 1) / s1.length();
        
        string repeatedS1 = "";
        for (int i = 0; i < minRepeats; ++i) {
            repeatedS1 += s1;
        }
        
        if (repeatedS1.find(s2) != string::npos) {
            return minRepeats;
        }
        
        repeatedS1 += s1;
        if (repeatedS1.find(s2) != string::npos) {
            return minRepeats + 1;
        }
        
        return -1;
    }
};
