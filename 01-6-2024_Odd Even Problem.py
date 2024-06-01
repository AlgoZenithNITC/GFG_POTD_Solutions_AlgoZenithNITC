class Solution:
    @staticmethod
    def oddEven(s):
        x = 0
        y = 0

        # Iterate over all characters from 'a' to 'z'
        for ch in range(ord('a'), ord('z') + 1):
            count = 0

            # Count occurrences of the current character in the string
            for c in s:
                if c == chr(ch):
                    count += 1

            # Determine the position of the character in the alphabet (1-indexed)
            position = ch - ord('a') + 1

            # Check conditions for X and Y
            if count > 0:
                if position % 2 == 0 and count % 2 == 0:
                    x += 1
                elif position % 2 != 0 and count % 2 != 0:
                    y += 1

        # Determine if the sum of X and Y is even or odd
        if (x + y) % 2 == 0:
            return "EVEN"
        else:
            return "ODD"
