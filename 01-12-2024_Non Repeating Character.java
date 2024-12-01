
class Solution {
    // Function to find the first non-repeating character in a string
    public char nonRepeatingChar(String s) {
        int[] freq = new int[26]; // Frequency array for lowercase letters
        
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        
        return '$'; // No non-repeating character
    }
}