class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr) {

        // Your code here
        long maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere += arr[i];

            // Use Math.max to find the maximum 
            // of maxSoFar and maxEndingHere
            maxSoFar = Math.max(maxSoFar, maxEndingHere);

            // Use Math.max to reset maxEndingHere 
            // to 0 if it becomes negative
            maxEndingHere = Math.max(maxEndingHere, 0);
        }
        return maxSoFar;
        
    }
}
