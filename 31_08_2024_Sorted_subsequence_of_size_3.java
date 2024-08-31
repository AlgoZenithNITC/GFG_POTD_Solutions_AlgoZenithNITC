class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        int max = n - 1; // index of maximum element in the array
        int min = 0;     // index of minimum element in the array
        int[] smaller = new int[n];
        int[] greater = new int[n];
        smaller[0] = -1; // first entry will always be -1

        // Update the smaller array
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i; // updating the index of minimum element
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }

        greater[n - 1] = -1; // last entry will always be -1

        // Update the greater array
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i; // updating the index of maximum element
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }

        // List to store the result
        List<Integer> result = new ArrayList<>();

        // Find the triplet
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                result.add(arr[smaller[i]]);
                result.add(arr[i]);
                result.add(arr[greater[i]]);
                return result;
            }
        }
        return result;
    }
}
