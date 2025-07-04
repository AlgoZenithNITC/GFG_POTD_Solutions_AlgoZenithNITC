import java.util.*;

class Solution {
    public int countAtMostK(int[] arr, int k) {
        int left = 0, ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);
            if (freq.get(arr[right]) == 1) k--; // new distinct

            while (k < 0) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0) k++; // removed one distinct
                left++;
            }

            ans += (right - left + 1);
        }

        return ans;
    }
}
