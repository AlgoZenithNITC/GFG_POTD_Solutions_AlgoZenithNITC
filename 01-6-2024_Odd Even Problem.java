class Solution {
    static String oddEven(String s) {
        int x = 0, y = 0;

        // Iterate over all characters from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int count = 0;

            // Count occurrences of the current character in the string
            for (char c : s.toCharArray()) {
                if (c == ch) {
                    count++;
                }
            }

            // Determine the position of the character in the alphabet (1-indexed)
            int position = ch - 'a' + 1;

            // Check conditions for X and Y
            if (count > 0) {
                if (position % 2 == 0 && count % 2 == 0) {
                    x++;
                } else if (position % 2 != 0 && count % 2 != 0) {
                    y++;
                }
            }
        }

        // Determine if the sum of X and Y is even or odd
        if ((x + y) % 2 == 0) {
            return "EVEN";
        } else {
            return "ODD";
        }
    }
}
