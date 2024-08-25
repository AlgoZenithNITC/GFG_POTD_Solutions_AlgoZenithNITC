//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    long countPairs(int x[], int y[], int M, int N) {
        // Array to store counts of 0, 1, 2, 3 and 4 present in array y.
        int[] freq = new int[5];
        // Storing the count in array if y[i]<5.
        for (int i = 0; i < N; i++) {
            if (y[i] < 5) freq[y[i]]++;
        }
        // Sorting y[] so that we can do binary search on it later on.
        Arrays.sort(y);
        long ans = 0;
        // Taking every element of x[] and counting pairs with it.
        for (int i = 0; i < M; i++) {
            // If x[i] is 0, then there can't be any value in y[]
            // such that x[i]^y[val]>y[val]^x[i].
            if (x[i] == 0) continue;
            // If x[i] is 1, then the number of pair is equal to
            // number of zeroes in y[].
            if (x[i] == 1) {
                ans = ans + (long)freq[0];
                continue;
            }
            // We work with logic that if x<y then x^y is greater than y^x.
            // Finding number of elements in y[] with value greater than x.
            // binary() gets address of first element greater than x[i] in y[].
            int ind = binary(M, N, x[i], y);
            // Updating number of pairs.
            // If we have reached here, then x must be greater than 1.
            // Increasing number of pairs for y=0 and y=1 .
            ans = ans + (long)(N - ind) + (long)freq[0] + (long)freq[1];
            // Decreasing number of pairs for exception where x=2
            // and (y=4 or y=3).
            if (x[i] == 2) ans = ans - (long)freq[3] - (long)freq[4];
            // Increasing number of pairs for exception where x=3 and y=2.
            if (x[i] == 3) ans = ans + (long)freq[2];
        }
        // returning number of pairs.
        return ans;
    }

    // Function to find upper bound using binary search.
    public int binary(int M, int N, int x, int[] y) {
        int high = N - 1, low = 0;
        int ans = high + 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (y[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}
