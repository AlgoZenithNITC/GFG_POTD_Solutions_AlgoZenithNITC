class Solution {
    int countFreq(int[] arr, int target) {
      
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        int leftmost = -1;
        int rightmost = -1;

        // Find the leftmost occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= target) {
                leftmost = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (leftmost == -1 || arr[leftmost] != target) {
            return 0;
        }

        start = 0;
        end = n - 1;

        // Find the rightmost occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                rightmost = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (rightmost == -1 || arr[leftmost] != target) {
            return 0;
        }

        return (rightmost - leftmost) + 1;
    }
    
}
