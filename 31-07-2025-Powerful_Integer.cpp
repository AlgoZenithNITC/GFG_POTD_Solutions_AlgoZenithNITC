class Solution {
  public:
    int powerfulInteger(vector<vector<int>>& arr, int k) {
    map<int, int> diff;

    for (auto& interval : arr) {
        diff[interval[0]]++;
        diff[interval[1] + 1]--;
    }

    int active = 0, ans = -1;

    for (auto& [pos, delta] : diff) {
        if (active >= k && delta < 0) {
            ans = pos - 1;
        }
        active += delta;
    }

    return ans;
}
};