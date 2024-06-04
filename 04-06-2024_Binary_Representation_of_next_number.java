class Solution {
    String binaryNextNumber(String s) {
        // code here.
        int n = s.length();
        int i;
        StringBuilder sb = new StringBuilder(s);

        for (i = n - 1; i >= 0; i--) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '0');
            } else {
                sb.setCharAt(i, '1');
                break;
            }
        }

        if (i < 0) {
            sb.insert(0, '1');
        } else {
            i = 0;
            while (i < sb.length() && sb.charAt(i) == '0') {
                i++;
            }
            sb = new StringBuilder(sb.substring(i));
        }

        return sb.toString();
        
    }
}
