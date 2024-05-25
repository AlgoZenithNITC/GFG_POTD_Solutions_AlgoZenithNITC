class Solution {
    long max_Books(int arr[], int n, int k) {
        long a = 0;
        long maxBooks = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                a += arr[i];
            } else {
                a = 0;
            }
            maxBooks = Math.max(maxBooks, a);
        }
        return maxBooks;
    }
}
