class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        int left = 0, right = n - 2;
        int index = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr2[mid] == arr1[mid]) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }
}
