class Solution:
    def computeLPSArray(self, pat, M, lps):
        length = 0
        
        # Initializing the longest prefix suffix array
        lps[0] = 0
        i = 1
        
        while (i < M):
            # If the characters match, increment the length and store it in the lps array
            if pat[i] == pat[length]:
                length += 1
                lps[i] = length
                i += 1
            else:
                # If the characters don't match
                if length != 0:
                    # Update the length to the value at the previous index in the lps array
                    length = lps[length - 1]
                else:
                    # If the length is 0, assign 0 to the lps array and move to the next index
                    lps[i] = 0
                    i += 1

    def search(self, pat, txt):
        res = []
        M = len(pat)
        N = len(txt)
        
        # Initializing the longest prefix suffix array
        lps = [0 for i in range(M + 1)]

        j = 0
        
        # Calculate the longest prefix suffix array
        self.computeLPSArray(pat, M, lps)
        
        f = 0
        i = 0  # index for txt[]
        
        while i < N:
            # If the characters match, move to the next characters
            if pat[j] == txt[i]:
                j += 1
                i += 1

            if j == M:
                # If the entire pattern is found, append the starting index to the result list
                f += 1
                res.append(i - j + 1)
                j = lps[j - 1]

            # If there is a mismatch
            elif i < N and pat[j] != txt[i]:
                if j != 0:
                    # Update the j value to the value at the previous index in the lps array
                    j = lps[j - 1]
                else:
                    # If j is 0, move to the next character in the text
                    i = i + 1

        if f == 0:
            # If the pattern is not found in the text, append -1 to the result list
            res.append(-1)

        return res
