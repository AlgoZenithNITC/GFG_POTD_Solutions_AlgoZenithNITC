class Solution {
    public static int countTriangles(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        Arrays.sort(arr);
        int count = 0;

        // Fix the largest side one by one
        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    // All elements between left and right-1 with arr[right] form valid triangles
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;

    }
}
