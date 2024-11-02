class Solution {
    public boolean isCircularSentence(String s) {
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i - 1) != s.charAt(i + 1)) {
                return false;  // checking for circular substring condition
            }
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {  // checking for circular whole string condition
            return false;
        }
        return true;
    }
}
