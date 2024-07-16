class Solution {
    public String printString(String s, char ch, int count) {
        String str = "";
        int i = 0;
        while (i < s.length() && count != 0) {

            if (s.charAt(i) == ch) {
                count--;
                i++;
            } else if (s.charAt(i) != ch) {
                i++;
            }
        }

        if (count == 0) {
            str = s.substring(i);
        }

        return s.substring(i).equals("") ? "" : s.substring(i);
    }
}
