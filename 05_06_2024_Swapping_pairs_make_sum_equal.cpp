class Solution {
public:
    int findSwapValues(vector<int> a, int n, vector<int> b, int m) {
        int a_sum = accumulate(a.begin(), a.end(), 0);
        int b_sum = accumulate(b.begin(), b.end(), 0);
        if ((a_sum - b_sum) % 2 != 0) {
            return -1;
        }
        int diff = (a_sum - b_sum) / 2;
        unordered_set<int> a_set(a.begin(), a.end());
        for (int i : b) {
            if (a_set.find(i + diff) != a_set.end()) {
                return 1;
            }
        }
        return -1;
    }
};

