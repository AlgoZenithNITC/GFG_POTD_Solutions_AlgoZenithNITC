class Solution {
public:
    long long max_sum(int arr[], int n) {
        long long totalSum = 0;
        long long currentRotationSum = 0;

        // Calculate total sum of array elements and initial rotation sum
        for (long long i = 0; i < n; i++) {
            totalSum += arr[i];
            currentRotationSum += i * arr[i];
        }

        long long maxRotationSum = currentRotationSum;

        // Calculate rotation sums for all possible rotations and find the maximum
        for (long long i = 1; i < n; i++) {
            currentRotationSum = currentRotationSum - totalSum + 1LL * n * arr[i - 1];
            maxRotationSum = max(maxRotationSum, currentRotationSum);
        }

        return maxRotationSum;
    }
};
