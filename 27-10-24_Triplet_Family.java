class Solution {
    public boolean findTriplet(int[] arr) {
        Arrays.sort(arr);  // Sort the array
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            HashSet<Integer> seen = new HashSet<>();  // To track the seen elements
            
            // Iterate through the array up to the current element
            for (int j = 0; j < i; j++) {
                int complement = target - arr[j];
                if (seen.contains(complement)) {
                    // Uncomment the following line to print the triplet
                    // System.out.println("Triplet found: (" + complement + ", " + arr[j] + ", " + target + ")");
                    return true;  // Exit immediately after finding the first triplet
                }
                seen.add(arr[j]);
            }
        }

        return false;  // No triplet found
    }
}