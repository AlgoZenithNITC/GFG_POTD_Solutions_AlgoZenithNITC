class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int start = 0;
        int currentSum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            // Shrink the window as long as the sum is greater than the target
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if the current sum equals the target
            if (currentSum == target) {
                result.add(start + 1); // 1-based index
                result.add(end + 1);   // 1-based index
                return result;
            }
        }

        // If no subarray is found, return [-1]
        result.add(-1);
        return result;
    }
}
