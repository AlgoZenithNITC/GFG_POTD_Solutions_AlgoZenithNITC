class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] merged = new int[2 * n];
        int i = 0, j = 0, k = 0;

        // Merge the two arrays
        while (i < n && j < n) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        // Copy remaining elements of arr1
        while (i < n) {
            merged[k++] = arr1[i++];
        }
        // Copy remaining elements of arr2
        while (j < n) {
            merged[k++] = arr2[j++];
        }

        // Find the middle elements
        int middle1 = merged[n - 1];
        int middle2 = merged[n];

        // Return the sum of the two middle elements
        return middle1 + middle2;
    }
}
