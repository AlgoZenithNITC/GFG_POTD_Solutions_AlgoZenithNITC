class Solution:
    
    def BTToDLLUtil(self,root):
         
        """This is a utility function to 
        convert the binary tree to doubly 
        linked list. Most of the core task
        is done by this function."""
        if root is None:
            return root
     
        # Convert left subtree 
        # and link to root
        if root.left:
             
            # Convert the left subtree
            left = self.BTToDLLUtil(root.left)
     
            # Find inorder predecessor, After 
            # this loop, left will point to the 
            # inorder predecessor of root
            while left.right:
                left = left.right
     
            # Make root as next of predecessor
            left.right = root
             
            # Make predecessor as 
            # previous of root
            root.left = left
     
        # Convert the right subtree
        # and link to root
        if root.right:
             
            # Convert the right subtree
            right = self.BTToDLLUtil(root.right)
     
            # Find inorder successor, After 
            # this loop, right will point to 
            # the inorder successor of root
            while right.left:
                right = right.left
     
            # Make root as previous 
            # of successor
            right.left = root
             
            # Make successor as 
            # next of root
            root.right = right
     
        return root
    
    
    def bToDLL(self,root):
        # do Code here
        if root is None:
            return root
     
        # Convert to doubly linked 
        # list using BLLToDLLUtil
        root = self.BTToDLLUtil(root)
         
        # We need pointer to left most 
        # node which is head of the 
        # constructed Doubly Linked list
        while root.left:
            root = root.left
     
        return root
