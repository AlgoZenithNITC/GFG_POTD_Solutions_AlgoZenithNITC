class Solution {
    public int maxLen(int[] arr) {
        // HashMap to store the first occurrence of the prefix sum
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // Update the prefix sum: treat 1 as +1 and 0 as -1
            sum += (arr[i] == 1) ? 1 : -1;

            // If the sum is zero, the subarray from the start to i has sum zero
            if (sum == 0) {
                ans = i + 1;
            }

            // If the sum has been seen before, calculate the subarray length
            if (prefixSum.containsKey(sum)) {
                ans = Math.max(ans, i - prefixSum.get(sum));
            } else {
                // Store the first occurrence of this sum
                prefixSum.put(sum, i);
            }
        }

        return ans;
    }
}
