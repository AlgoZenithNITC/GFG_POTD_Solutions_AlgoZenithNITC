class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Place each number in its correct index if possible
        for (int i = 0; i < n; i++) {
            while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Find the first index where the number is incorrect
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
