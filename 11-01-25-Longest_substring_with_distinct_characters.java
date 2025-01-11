class Solution {
    public int longestUniqueSubstr(String s) {
        int maxLength = 0;
        String currentSubstring = "";

        for (char c : s.toCharArray()) {
            int pos = currentSubstring.indexOf(c);

            if (pos == -1) {
                currentSubstring += c;
                maxLength = Math.max(maxLength, currentSubstring.length());
            } else {
                currentSubstring = currentSubstring.substring(pos + 1) + c;
            }
        }

        return maxLength;
    }
}
