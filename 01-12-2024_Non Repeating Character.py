class Solution:
    # Function to find the first non-repeating character in a string.
    def nonRepeatingChar(self, s: str) -> str:
        a = [0] * 26  # Frequency array for lowercase letters
        
        # Count frequency of each character
        for char in s:
            a[ord(char) - ord('a')] += 1
        
        # Find the first non-repeating character
        for char in s:
            if a[ord(char) - ord('a')] == 1:
                return char
        
        return '$'  # No non-repeating character
