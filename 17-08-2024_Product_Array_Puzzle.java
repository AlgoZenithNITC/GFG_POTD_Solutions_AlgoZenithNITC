class Solution {
    public static long[] productExceptSelf(int nums[]) {
        int n = nums.length;
        
        if (n == 1) {
            return new long[]{1};
        }

        long[] left = new long[n];
        long[] right = new long[n];

        long[] prod = new long[n];
        left[0] = 1;

        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        for (int j = n - 2; j >= 0; j--) {
            right[j] = nums[j + 1] * right[j + 1];
        }

        for (int i = 0; i < n; i++) {
            prod[i] = left[i] * right[i];
        }

        return prod;
    }
}
