from collections import Counter
class Solution:
    def findGreater(self, arr):
        n = len(arr)
        freq = Counter(arr)
        res = [-1] * n
        stack = []
    
        for i in range(n - 1, -1, -1):
            # Pop elements with frequency <= current element's frequency
            while stack and freq[stack[-1]] <= freq[arr[i]]:
                stack.pop()
    
            # Top of the stack is the answer if exists
            if stack:
                res[i] = stack[-1]
            else:
                res[i] = -1
    
            # Push current element for future comparisons
            stack.append(arr[i])
    
        return res
