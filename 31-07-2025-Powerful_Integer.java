import java.util.*;

class Solution {
    public int powerfulInteger(int[][] arr, int k) {
        TreeMap<Integer, Integer> diff = new TreeMap<>();

        // Build the difference map
        for (int[] interval : arr) {
            diff.put(interval[0], diff.getOrDefault(interval[0], 0) + 1);
            diff.put(interval[1] + 1, diff.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int active = 0;
        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int pos = entry.getKey();
            int delta = entry.getValue();

            if (active >= k && delta < 0) {
                ans = pos - 1;
            }

            active += delta;
        }

        return ans;
    }
}
