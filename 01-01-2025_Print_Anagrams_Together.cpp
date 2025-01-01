#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<vector<string>> anagrams(vector<string>& arr) {
        unordered_map<string, vector<string>> map;
        
        // Grouping anagrams
        for (string str : arr) {
            string sortedStr = str;
            sort(sortedStr.begin(), sortedStr.end());
            map[sortedStr].push_back(str);
        }
        
        // Collecting results
        vector<vector<string>> result;
        for (auto& entry : map) {
            result.push_back(entry.second);
        }
        
        // Sorting groups lexicographically
        sort(result.begin(), result.end());
        return result;
    }
};
