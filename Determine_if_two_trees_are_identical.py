class Solution:
    def isIdentical(self, root1, root2):
        if root1 is None and root2 is None:
            return True
        if root1 is None or root2 is None or root1.data != root2.data:
            return False
        return self.isIdentical(root1.left, root2.left) and self.isIdentical(root1.right, root2.right)
