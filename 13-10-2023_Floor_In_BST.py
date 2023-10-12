class Solution:
    def floor(self, root, x):
        if root is None:
            return -1
        present = float('-inf')
        if root.data > x:
            temp = self.floor(root.left, x)
        elif root.data <= x:
            present = root.data
            temp = self.floor(root.right, x)
        return max(present, temp)
