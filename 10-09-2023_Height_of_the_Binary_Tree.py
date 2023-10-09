class Solution:
    #Function to find the height of a binary tree.
    def height(self, node):
        return 0 if not node else 1 + max(self.height(node.left), self.height(node.right))
