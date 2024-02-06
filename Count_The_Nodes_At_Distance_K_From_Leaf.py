class Solution:
    def printKDistantfromLeaf(self, root, k):
        #code here
        self.lis=[]
        self.se=set()
        self.helper(root)
        return len(self.se)

    def helper(self, root):
        if root==None:
            return
        self.lis.append(root)
        if root.left==None and root.right==None:
            dis=len(self.lis)-k-1
            if dis>=0:
                self.se.add(self.lis[dis])
            self.lis.pop()
            return
        self.helper(root.left)
        self.helper(root.right)
        self.lis.pop()
