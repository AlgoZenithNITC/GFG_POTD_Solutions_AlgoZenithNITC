//Back-end complete function template for C++.

//Position this line where user code will be pasted.
class Solution {
  public:
    int SumofMiddleElements(vector<int> &arr1, vector<int> &arr2) {
        int n = arr1.size();
        int low = 0, high = n;

        while (low <= high) {
            // Partition points in both arrays
            int cut1 = (low + high) / 2;
            int cut2 = n - cut1;

            // Elements around the partition points
            int l1 = (cut1 == 0) ? INT_MIN : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? INT_MIN : arr2[cut2 - 1];
            int r1 = (cut1 == n) ? INT_MAX : arr1[cut1];
            int r2 = (cut2 == n) ? INT_MAX : arr2[cut2];

            // Check if we have found the correct partition
            if (l1 <= r2 && l2 <= r1) {
                // Return the sum of the middle elements
                return max(l1, l2) + min(r1, r2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        // This case will never occur for valid input
        return 0;
    }
};
