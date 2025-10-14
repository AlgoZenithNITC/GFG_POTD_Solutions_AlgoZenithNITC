"""
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
"""
class Solution:
    def nodeSum(self, root, l, r):
        # code here
        s=0
        def recurse(root):
            nonlocal s
            if root!=None:
                if l<=root.data<=r:
                    s+=root.data
                recurse(root.left)
                recurse(root.right)
        recurse(root)
        return s
        
        
