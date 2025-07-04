class Solution {
  public:
    int countAtMostK(vector<int>& arr, int k) {
        int n = arr.size();
        unordered_map<int, int> freq;
        int left = 0, ans = 0;

        for (int right = 0; right < n; ++right) {
            if (freq[arr[right]] == 0) k--;
            freq[arr[right]]++;

            while (k < 0) {
                freq[arr[left]]--;
                if (freq[arr[left]] == 0) k++;
                left++;
            }

            ans += (right - left + 1);
        }

        return ans;
    }
};
