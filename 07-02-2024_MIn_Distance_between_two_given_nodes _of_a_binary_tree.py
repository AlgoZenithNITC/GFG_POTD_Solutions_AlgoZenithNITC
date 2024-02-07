class Solution:

    def __init__(self):
        self.ans = 0
    
    def findDist(self, root, a, b):
        if a == b:
            return 0
            
        def lca_dist(root):
            if not root or self.ans > 0:
                return 0
            
            l = lca_dist(root.left)
            r = lca_dist(root.right)
            
            if root.data == a or root.data == b:
                if l or r:
                    self.ans = l if l!=0 else r
                else:
                    return 1
            
            if l and r:
                self.ans = l + r
            elif l or r:    # In path of a to b
                return l + 1 if l!=0 else r+1
            return 0    # not in path
            
        lca_dist(root)
        return self.ans
        
