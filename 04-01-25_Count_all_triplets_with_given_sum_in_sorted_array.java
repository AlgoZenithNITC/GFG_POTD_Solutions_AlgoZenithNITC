import java.util.Scanner;

public class Solution {

    public static long countTriplets(int[] arr, int target) {
        int n = arr.length;
        long res = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    int ele1 = arr[left];
                    int ele2 = arr[right];
                    int cnt1 = 0;
                    int cnt2 = 0;

                    // Count the occurrences of arr[left] from left
                    while (left <= right && arr[left] == ele1) {
                        left++;
                        cnt1++;
                    }

                    // Count the occurrences of arr[right] from right
                    while (left <= right && arr[right] == ele2) {
                        right--;
                        cnt2++;
                    }

                    // If ele1 and ele2 are the same, calculate the combination of cnt1
                    if (ele1 == ele2) {
                        res += (long) (cnt1 * (cnt1 - 1)) / 2;
                    } else {
                        res += (long) (cnt1 * cnt2);
                    }
                }
            }
        }

        return res;
    }


