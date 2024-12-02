class Solution {
    private int[] computePrefix(String pattern) {
        int k = 0, i = 1, n = pattern.length(); 
        int[] prefixArray = new int[n];

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(k)) {
                k++;
                prefixArray[i] = k;
                i++;
            } else {
                if (k != 0) {
                    k = prefixArray[k - 1];
                } else {
                    prefixArray[i] = 0;
                    i++;
                }
            }
        }
        return prefixArray;
    }

    ArrayList<Integer> search(String pat, String txt) {
        int textLength = txt.length();
        int patternLength = pat.length();
        int[] prefixArray = computePrefix(pat);
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0; 

        while (i < textLength) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++; j++;
                if (j == patternLength) {
                    result.add(i - j); 
                    j = prefixArray[j - 1];
                }
            } else {
                if (j != 0) {
                    j = prefixArray[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }
}
