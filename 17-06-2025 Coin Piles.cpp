class Solution {
  public:
    int minimumCoins(vector<int>& arr, int k) {
        int n = arr.size();

        sort(arr.begin(), arr.end());

        int total = 0;
        for (int x : arr)
            total += x;

        int minRemoved = total;
        int windowSum = 0;
        int prefix = 0;
        int end = 0;

        for (int start = 0; start < n; start++) {

            // Expand the window to include elements
            // within k difference from arr[start]
            while (end < n && arr[end] - arr[start] <= k) {
                windowSum += arr[end];
                end++;
            }

            // Calculate the upper limit allowed
            // for pile values in the window
            int upper = arr[start] + k;

            int rightCount = n - end;

            // Calculate how many coins need
            // to be removed from right-side piles
            int removeRight = (total - prefix - windowSum) - rightCount * upper;
            int removed = prefix + removeRight;
            minRemoved = min(minRemoved, removed);

            if (end == start) {
                end++;
            } else {
                windowSum -= arr[start];
            }

            prefix += arr[start];
        }

        return minRemoved;
    }
};
