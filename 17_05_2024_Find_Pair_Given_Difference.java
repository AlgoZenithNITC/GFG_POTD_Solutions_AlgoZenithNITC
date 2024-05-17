class Solution {
    public int findPair(int n, int x, int[] arr) {
        Arrays.sort(arr);
        int i = 0, j = 1;
        while (i < arr.length && j < arr.length) {
            if (arr[j] - arr[i] == x && j != i) {
                return 1;
            }
            if (arr[j] - arr[i] > x) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
}
