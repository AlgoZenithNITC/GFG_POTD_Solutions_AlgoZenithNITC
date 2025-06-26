import java.util.*;

class Solution {
    public int minValue(String s, int k) {
        // Frequency array for characters a-z
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Max heap (priority queue) for frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f != 0) {
                pq.add(f);
            }
        }

        // Reduce the highest frequency k times
        while (k-- > 0 && !pq.isEmpty()) {
            int mx = pq.poll();
            if (mx > 1) {
                pq.add(mx - 1);
            } // if mx == 1, just discard
        }

        // Compute the sum of squares of remaining frequencies
        int sum = 0;
        while (!pq.isEmpty()) {
            int val = pq.poll();
            sum += val * val;
        }

        return sum;
    }
}
