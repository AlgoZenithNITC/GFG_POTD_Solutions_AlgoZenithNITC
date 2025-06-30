class Solution {
  public:
    // Function to check if it is possible to make
    // every flower at least minHeight with given days
    bool isPossible(vector<int> &arr, int k, int w, int maxHeight) {

        int n = arr.size();
        vector<int> water(n, 0);

        for (int i = 0; i < n; i++) {

            // Add previous watering effect
            if (i > 0) {
                water[i] = water[i - 1];
            }

            int currHeight = arr[i] + water[i];

            // Remove watering effect beyond window w
            if (i >= w) {
                currHeight -= water[i - w];
            }

            // If current height is less than required
            if (currHeight < maxHeight) {
                int add = maxHeight - currHeight;
                water[i] += add;
                k -= add;

                // If days become negative, not possible
                if (k < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    int maxMinHeight(vector<int> &arr, int k, int w) {
        int n = arr.size();

        // Find minimum height manually
        int low = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < low) {
                low = arr[i];
            }
        }

        int high = low + k;
        int ans = low;

        // Binary Search on the answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, k, w, mid)) {
                ans = max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
};
