#User function Template for python3
class Solution:
    def longestCommonPrefix(self, arr):
        if not arr:  # Base case: empty list
            return "-1"

        min_len = min(len(s) for s in arr)  # Find shortest string length efficiently

        prefix = ""
        for i in range(min_len):
            char = arr[0][i]  # Get character to compare from the first string
            if all(s[i] == char for s in arr):  # Check if all strings have same char
                prefix += char
            else:
                break

        return prefix if prefix else "-1"  # Return prefix or "-1" if none
