class Solution {
  public:
    vector<int> subarraySum(vector<int> &arr, int target) {
        int start = 0;
        int currentSum = 0;
        int n = arr.size();

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            // Shrink the window as long as the sum is greater than the target
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if the current sum equals the target
            if (currentSum == target) {
                return {start + 1, end + 1}; // Return 1-based indices
            }
        }

        // If no subarray is found, return [-1]
        return {-1};
    }
};
