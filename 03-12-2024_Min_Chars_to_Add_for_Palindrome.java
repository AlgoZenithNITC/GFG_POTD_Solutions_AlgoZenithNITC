class Solution {
    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // Helper function to compute the LPS (Longest Prefix Suffix) array
    private static void computeLongestPrefixSuffix(String str, int[] lps) {
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static int minChar(String s) {
        int len = s.length();
        String revStr = reverseString(s); // Reverse the string

        // Concatenate original string, delimiter, and reversed string
        String concat = s + "|" + revStr;
        int concatLen = concat.length();
        int[] lps = new int[concatLen];

        // Compute the LPS array for the concatenated string
        computeLongestPrefixSuffix(concat, lps);

        // Minimum characters to add = original length - LPS of concatenated string
        return len - lps[concatLen - 1];
    }
}
