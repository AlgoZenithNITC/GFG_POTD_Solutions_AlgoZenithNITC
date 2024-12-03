class Solution:
    def minChar(self, s):
        # Helper function to reverse a string
        def reverse_string(s):
            return s[::-1]

        # Helper function to compute the LPS (Longest Prefix Suffix) array
        def compute_longest_prefix_suffix(s):
            n = len(s)
            lps = [0] * n
            length = 0
            i = 1

            while i < n:
                if s[i] == s[length]:
                    length += 1
                    lps[i] = length
                    i += 1
                else:
                    if length != 0:
                        length = lps[length - 1]
                    else:
                        lps[i] = 0
                        i += 1
            return lps

        # Reverse the string
        rev_str = reverse_string(s)

        # Concatenate original string, delimiter, and reversed string
        concat = s + "|" + rev_str

        # Compute the LPS array for the concatenated string
        lps = compute_longest_prefix_suffix(concat)

        # Minimum characters to add = original length - LPS of concatenated string
        return len(s) - lps[-1]
