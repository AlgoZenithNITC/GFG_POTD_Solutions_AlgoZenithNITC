class Solution {
    public int countPairs(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        int count = 0;
        while (l < r) {
            if (arr[l] + arr[r] >= target) {
                r--;
            } else {
                count += r - l;
                l++;
            }
        }
        return count;
    }
}
