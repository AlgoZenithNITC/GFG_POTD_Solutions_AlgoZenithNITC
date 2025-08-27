class Solution {
  public:
    int countTriangles(vector<int>& arr) {
    int n = arr.size();
    if (n < 3) return 0;

    sort(arr.begin(), arr.end());
    int count = 0;
    for (int i = n - 1; i >= 1; i--) {
        int left = 0, right = i - 1;
        while (left < right) {
            if (arr[left] + arr[right] > arr[i]) {
                count += (right - left);
                right--;
            } else {
                left++;
            }
        }
    }
    return count;
}
};
