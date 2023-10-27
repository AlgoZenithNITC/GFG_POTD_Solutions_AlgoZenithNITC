class Solution:
    def minimumNumberOfDeletions(self, S):
        first = S
        second = S[::-1]
        n = len(first)
        prev = [0]*(n + 1)
        for i in range(1, n + 1):
            curr = [0]*(n + 1)
            for j in range(1, n + 1):
                if first[i - 1] == second[j - 1]:
                    curr[j] = 1 + prev[j - 1]
                else:
                    left = curr[j - 1]
                    top = prev[j]
                    curr[j] = max(left, top)
            prev = curr
        return len(S) - prev[n]
