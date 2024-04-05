class Solution {
    public String makeGood(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (ans.length() == 0) {
                ans.append(s.charAt(i));
            } else if (ans.length() > 0 && ans.charAt(ans.length() - 1) != s.charAt(i) && Character.toLowerCase(ans.charAt(ans.length() - 1)) == Character.toLowerCase(s.charAt(i))) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}

