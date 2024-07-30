class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        int[] countA = new int[n];
        int aCount = 0;

        // First pass: compute count_a which stores the number of
        // 'a' characters to the right of the current position
        for (int i = n - 1; i >= 0; i--) {
            countA[i] = aCount;
            if (s.charAt(i) == 'a') aCount++;
        }

        int minDeletions = n;
        int bCount = 0;
        // Second pass: compute minimum deletions on the fly
        for (int i = 0; i < n; i++) {
            minDeletions = Math.min(countA[i] + bCount, minDeletions);
            if (s.charAt(i) == 'b') bCount++;
        }

        return minDeletions;
    }
}
