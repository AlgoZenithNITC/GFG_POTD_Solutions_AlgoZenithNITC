class Solution {
    long max_sum(int a[], int n) {
       long totalSum = 0;
        long currentRotationSum = 0;

        // Calculate total sum of array elements and initial rotation sum
        for (int i = 0; i < n; i++) {
            totalSum += a[i];
            currentRotationSum += (long)i * a[i];
        }

        long maxRotationSum = currentRotationSum;

        // Calculate rotation sums for all possible rotations and find the maximum
        for (int i = 1; i < n; i++) {
            currentRotationSum = currentRotationSum - totalSum + (long)n * a[i - 1];
            maxRotationSum = Math.max(maxRotationSum, currentRotationSum);
        }

        return maxRotationSum;
    }
}
