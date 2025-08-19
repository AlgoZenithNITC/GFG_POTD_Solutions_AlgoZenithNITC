import java.util.*;

class Solution {
    public int[] farMin(int[] arr) {
        int n = arr.length;
        
        int[] suffix = new int[n + 1];
        Arrays.fill(suffix, Integer.MAX_VALUE);

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], arr[i]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n - 1; i++) {
            int low = i + 1;
            int high = n - 1;
            int res = -1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (suffix[mid] < arr[i]) {
                    res = mid;
                    low = mid + 1; // move right to find farthest
                } else {
                    high = mid - 1;
                }
            }
            ans[i] = res;
        }
        return ans;
    }
}
