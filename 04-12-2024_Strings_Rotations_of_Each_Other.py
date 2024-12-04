class Solution:
    
    # Function to compute the Longest Prefix Suffix (LPS) array
    def LPS(self, s):
        n = len(s)
        arr = [0] * n

        for i in range(1, n):
            j = arr[i - 1]

            while j > 0 and s[i] != s[j]:
                j = arr[j - 1]

            if s[i] == s[j]:
                j += 1

            arr[i] = j

        return arr

    # Function to check if two strings are rotations of each other or not
    def areRotations(self, s1, s2):
        if len(s1) != len(s2):
            return False

        s1_2 = s1 + s1  # Concatenate s1 with itself
        arr = self.LPS(s2)  # Compute LPS array for s2
        j = 0

        for i in range(len(s1_2)):
            while j > 0 and s1_2[i] != s2[j]:
                j = arr[j - 1]

            if s1_2[i] == s2[j]:
                j += 1

            if j == len(s2):
                return True

        return False
