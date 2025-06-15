import java.util.Arrays;

class Solution {
    public boolean check(int[] arr, int mid, int k) {
        int sum = 0;
        for (int i : arr) {
            sum += (i + mid - 1) / mid;
            if (sum > k) return false;
        }
        return true;
    }

    public int smallestDivisor(int[] arr, int k) {
        if (k == arr.length) return Arrays.stream(arr).max().getAsInt();
        int left = 1;
        int right = Arrays.stream(arr).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(arr, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}