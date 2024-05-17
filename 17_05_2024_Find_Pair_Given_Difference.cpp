class Solution {
  public:
    int findPair(int n, int x, vector<int> &arr) {
        unordered_set<int> elements;
        for (int i = 0; i < n; ++i) {
            if (elements.find(arr[i] + x) != elements.end() ||
                elements.find(arr[i] - x) != elements.end()) {
                return 1;
            }
            elements.insert(arr[i]);
        }
        return -1;
    }
};
