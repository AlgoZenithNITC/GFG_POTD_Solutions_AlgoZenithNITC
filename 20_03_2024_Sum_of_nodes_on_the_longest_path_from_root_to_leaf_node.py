class Solution:
    def solve(self, root, sum, length, maxsum, maxlength):
        if root is None:
            if maxlength == length:
                maxsum = max(maxsum, sum)
            elif maxlength < length:
                maxsum = sum
                maxlength = length
            return
        sum = sum + root.data
        length = length + 1
        self.solve(root.left, sum, length, maxsum, maxlength)
        self.solve(root.right, sum, length, maxsum, maxlength)

    def sumOfLongRootToLeafPath(self, root):
        sum = 0
        length = 0
        maxsum = 0
        maxlength = 0
        self.solve(root, sum, length, maxsum, maxlength)
        return maxsum

