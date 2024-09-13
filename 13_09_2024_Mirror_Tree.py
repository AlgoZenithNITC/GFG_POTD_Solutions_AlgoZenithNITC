class Solution:
    # Function to convert a binary tree into its mirror tree.
    def mirror(self, node):
        if node is None:
            return
        
        self.mirror(node.left)
        self.mirror(node.right)
        
        temp = node.left
        node.left = node.right
        node.right = temp
        
        return

