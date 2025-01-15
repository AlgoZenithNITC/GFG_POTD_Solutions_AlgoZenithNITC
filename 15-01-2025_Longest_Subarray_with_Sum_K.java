class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int psum = 0;

        for (int i = 0; i < n; i++) {
            psum += arr[i];

            if (psum == k) {
                ans = i + 1;
            }

            if (map.containsKey(psum - k)) {
                ans = Math.max(ans, i - map.get(psum - k));
            }

            if (!map.containsKey(psum)) {
                map.put(psum, i);
            }
        }

        return ans;
    }
}
