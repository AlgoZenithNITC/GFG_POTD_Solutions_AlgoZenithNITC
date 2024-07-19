class Solution {
  public:
    vector<int> constructLowerArray(vector<int> &arr) {
        // code here
    int n = arr.size();
    vector<int> ans(n, 0);

    for (int i = 0; i < n; ++i) {
        int count = 0;
        for (int j = i + 1; j < n; ++j) {
            if (arr[j] < arr[i]) {
                count++;
            }
        }
        ans[i] = count;
    }

    return ans;
    }
};
