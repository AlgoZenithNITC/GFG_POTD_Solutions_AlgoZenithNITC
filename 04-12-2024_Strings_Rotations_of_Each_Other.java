class Solution {

    // Function to compute the Longest Prefix Suffix (LPS) array
    private static int[] LPS(String s) {
        int n = s.length();
        int[] arr = new int[n];

        for (int i = 1; i < n; i++) {
            int j = arr[i - 1];

            // Update j while there is a mismatch
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = arr[j - 1];
            }

            // If there is a match, increment j
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            arr[i] = j;
        }

        return arr;
    }

    // Function to check if two strings are rotations of each other or not
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false; // Strings of different lengths cannot be rotations
        }

        String s1_2 = s1 + s1; // Concatenate s1 with itself
        int[] lps = LPS(s2); // Compute the LPS array for s2
        int j = 0; // Pointer for s2

        for (int i = 0; i < s1_2.length(); i++) {
            // Update j while there is a mismatch
            while (j > 0 && s1_2.charAt(i) != s2.charAt(j)) {
                j = lps[j - 1];
            }

            // If there is a match, increment j
            if (s1_2.charAt(i) == s2.charAt(j)) {
                j++;
            }

            // If we reach the end of s2, a rotation is found
            if (j == s2.length()) {
                return true;
            }
        }

        return false; // No rotation found
    }

}
