class Solution:
    
    b=1
    def isSum(self,root):
        if root==None: return 0
        l=self.isSum(root.left)
        r=self.isSum(root.right)
        if (root.left!=None or root.right!=None) and l+r!=root.data: self.b=0
        return root.data
        
    def isSumProperty(self, root):
        # code here
        self.isSum(root)
        return self.b
