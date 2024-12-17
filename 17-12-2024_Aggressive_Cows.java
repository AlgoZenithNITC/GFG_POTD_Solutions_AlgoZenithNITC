import java.util.*;

public class AggressiveCows {
    
    // Function to check if we can place 'k' cows with at least 'dist' distance apart
    public static boolean check(List<Integer> stalls, int k, int dist) {
        int cnt = 1; // Place the first cow
        int prev = stalls.get(0); // Position of the last cow placed

        for (int i = 1; i < stalls.size(); i++) {
            // If the current stall is at least 'dist' away from the previous one, place the cow here
            if (stalls.get(i) - prev >= dist) {
                prev = stalls.get(i);
                cnt++;
            }
        }

        // Return true if we are able to place all 'k' cows
        return cnt >= k;
    }

    // Function to find the largest minimum distance
    public static int aggressiveCows(List<Integer> stalls, int k) {
        // Sort the stalls to ensure they are in sequence
        Collections.sort(stalls);

        int res = 0;

        // Define the search space for binary search
        int lo = 1;
        int hi = stalls.get(stalls.size() - 1) - stalls.get(0);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // If it is possible to place the cows with this 'mid' distance
            if (check(stalls, k, mid)) {
                res = mid; // Update the result
                lo = mid + 1; // Search for a larger minimum distance
            } else {
                hi = mid - 1; // Reduce the search space
            }
        }

        return res;
    }

    // Driver function
    public static void main(String[] args) {
        List<Integer> stalls = Arrays.asList(1, 2, 8, 4, 9);
        int k = 3; // Number of cows

        int result = aggressiveCows(stalls, k);
        System.out.println("The largest minimum distance is: " + result);
    }
}
