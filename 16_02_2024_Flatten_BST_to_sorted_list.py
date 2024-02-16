import sys
sys.setrecursionlimit(10**5)
class Solution:
    def flattenBST(self, root):
        # code here
        prev, head = None, root
        def dfs(node):
            nonlocal prev, head
            
            if not node:
                return
            
            dfs(node.left)
            
            if not prev:
                head = node
            else:    
                node.left = None
                prev.right = node
                
            prev = node
            dfs(node.right)
            
            return head

        return dfs(root)

 
