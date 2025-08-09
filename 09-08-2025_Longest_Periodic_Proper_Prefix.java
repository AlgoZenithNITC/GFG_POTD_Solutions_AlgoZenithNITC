class Solution {
    int getLongestPrefix(String s) {
        // code here
        int n = s.length();
        if (n <= 1) return -1;

        // Build LPS array (KMP prefix function)
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        int b = lps[n - 1]; // largest border length
        if (b == 0) return -1; // no border -> no periodic proper prefix

        // Walk down the border chain to the smallest positive border
        while (b > 0 && lps[b - 1] > 0) {
            b = lps[b - 1];
        }

        return n - b;
    }
}
