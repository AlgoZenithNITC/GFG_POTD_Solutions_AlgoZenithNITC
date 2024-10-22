
class Solution {
  public:
    int sameOccurrence(vector<int>& arr, int x, int y) {
        unordered_map<int, int> dict;
        int count = 0;
        int output = 0;
        dict[0] = 1;
        for (int num: arr) {
            if (num == x) {
                count++;
            } else if (num == y) {
                count--;
            }
            if (dict.find(count) != dict.end()) {
                output += dict[count];
            }
            dict[count]++;
        }
        return output;
    }
};
