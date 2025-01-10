import java.util.*;

class Solution {
    public ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        int n = arr.length;
        int distinctCount = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            if (!hash.containsKey(arr[i])) {
                distinctCount++;
            }
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        ans.add(distinctCount);

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove the element going out of the window
            if (hash.get(arr[i - k]) == 1) {
                distinctCount--;
            }
            hash.put(arr[i - k], hash.get(arr[i - k]) - 1);

            // Add the new element coming into the window
            if (!hash.containsKey(arr[i]) || hash.get(arr[i]) == 0) {
                distinctCount++;
            }
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);

            ans.add(distinctCount);
        }

        return ans;
    }
}
