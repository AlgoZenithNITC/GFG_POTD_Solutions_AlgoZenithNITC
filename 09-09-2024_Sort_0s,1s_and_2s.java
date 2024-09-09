class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int n = arr.size();
        int low = 0, high = n - 1, mid = 0;

        // Using the Dutch National Flag algorithm
        while (mid <= high) {
            if (arr.get(mid) == 0) {
                Collections.swap(arr, mid++, low++);
            } else if (arr.get(mid) == 1) {
                mid++;
            } else {
                Collections.swap(arr, mid, high--);
            }
        }
    }
}
