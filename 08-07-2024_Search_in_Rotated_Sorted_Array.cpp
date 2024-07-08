class Solution {
  public:
    // Function to search for a key in a rotated sorted array.
    int search(vector<int>& arr, int key) {
        int n = arr.size();
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            // If middle element is the key
            if (arr[mid] == key)
                return mid;

            // If the left part is sorted
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= key && key <= arr[mid]) {
                    // key is in the left part
                    end = mid - 1;
                } else {
                    // key is in the right part
                    start = mid + 1;
                }
            } else { // If the right part is sorted
                if (arr[mid] <= key && key <= arr[end]) {
                    // key is in the right part
                    start = mid + 1;
                } else {
                    // key is in the left part
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
};
