class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int n = arr.length;
        int ans = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            ans += arr[i] * (n - count) * (count + 1);
            count++;
        }
