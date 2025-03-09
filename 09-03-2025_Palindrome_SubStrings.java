class Solution {
    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 >= 2) {
                count++;
            }
            left--;
            right++;
        }
        return count;
    }
    
    public int countPS(String s) {
        int n = s.length();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            count += expandAroundCenter(s, i, i);      // Odd-length palindromes
            count += expandAroundCenter(s, i, i + 1);  // Even-length palindromes
        }
        
        return count;
    }
