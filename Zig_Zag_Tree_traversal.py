

'''
class Node:
    def __init__(self,val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
   
    def solve(self, root, temp):
        if not root:
            return
        
        s1 = []
        s2 = []
        
        s1.append(root)
        
        while s1 or s2:
            while s1:
                curr = s1.pop()
                temp.append(curr.data)
                if curr.left:
                    s2.append(curr.left)
                if curr.right:
                    s2.append(curr.right)
            
            while s2:
                curr = s2.pop()
                temp.append(curr.data)
                if curr.right:
                    s1.append(curr.right)
                if curr.left:
                    s1.append(curr.left)
        
    # Main function to get zig zag traversal of tree
    def zigZagTraversal(self, root):
        temp = []
        self.solve(root, temp)
        return temp

