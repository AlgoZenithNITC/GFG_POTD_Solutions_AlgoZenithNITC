class Solution:
    def __init__(self):
        self.prev=None
    
    #Function to check whether a Binary Tree is BST or not.
    def isBST(self, root):
        return self.inorder(root)
    
    def inorder(self, root):
        if root is None:
            return True
        
        if not self.inorder(root.left):
            return False
        
        # Check BST condition
        if self.prev is not None and root.data <= self.prev:
            return False
        
        self.prev = root.data # update prev to current node's value
        
        return self.inorder(root.right)
