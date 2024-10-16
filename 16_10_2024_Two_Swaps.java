class Solution {

    // Function to swap once in case of mismatch
    public void doOneSwap(int n, List<Integer> arr) {
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != i + 1) {
                for (int j = i + 1; j < n; j++) {
                    if (arr.get(j) == i + 1) {
                        Collections.swap(arr, i, j);
                        return;
                    }
                }
            }
        }
    }

    // Function to check if sorted or can be sorted with a maximum of two swaps
    public boolean checkSorted(List<Integer> arr) {
        int n = arr.size();
        int misMatch = 0;

        // Count mismatches
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != i + 1) misMatch++;
        }

        // Edge case if size is 1
        if (n == 1) return false;

        // If already sorted or only 3 mismatches
        if (misMatch == 0 || misMatch == 3) return true;

        // If mismatches are not exactly 4, return false
        if (misMatch != 4) return false;

        // Perform two swaps
        doOneSwap(n, arr);
        doOneSwap(n, arr);

        // Final check if sorted
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != i + 1) return false;
        }
        return true;
    }
}
