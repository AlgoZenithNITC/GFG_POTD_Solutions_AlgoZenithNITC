

class Solution {
    public int pairWithMaxSum(int[] arr) {
        int n = arr.length;
        if (n == 1) return -1;
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, arr[i] + arr[i - 1]);
        }

        return ans;
    }
}
