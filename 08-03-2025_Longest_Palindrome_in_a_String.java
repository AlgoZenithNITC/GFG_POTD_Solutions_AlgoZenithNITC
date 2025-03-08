static String longestPalindrome(String s) {
    int n = s.length();
    int begin = 0, end = 0, len = 0;
    String ans = "";

    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= 1; j++) {
            int x = i;  // Case for odd length
            int y = i + j; // Case for even length

            while (x >= 0 && y < n && s.charAt(x) == s.charAt(y)) {
                int currLen = y - x + 1;
                if (currLen > len) {
                    begin = x;
                    end = y;
                    len = currLen;
                }
                x--;
                y++;
            }
        }
    }

    return s.substring(begin, end + 1);
}
