#include <unordered_map>
#include <vector>

class Solution {
public:
    bool checkDuplicatesWithinK(const std::vector<int>& arr, int k) {
        std::unordered_map<int, int> dict;

        for (int i = 0; i < arr.size(); ++i) {
            if (dict.find(arr[i]) != dict.end() && i - dict[arr[i]] <= k) {
                return true;
            }
            dict[arr[i]] = i;
        }

        return false;
    }
};
