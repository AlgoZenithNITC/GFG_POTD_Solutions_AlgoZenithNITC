class Solution:
    def findLength(self, color, radius):
        stack = []
        for c, r in zip(color, radius):
            if stack and stack[-1] == (c, r):
                stack.pop()
            else:
                stack.append((c, r))
        return len(stack)
