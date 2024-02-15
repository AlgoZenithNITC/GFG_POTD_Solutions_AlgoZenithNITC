class Solution {
public:
    int isPossible(vector<vector<int>>& paths) {
        for (auto& path : paths) {
            int sum = accumulate(path.begin(), path.end(), 0);
            if (sum % 2 != 0) {
                return 0;
            }
        }
        return 1;
    }
