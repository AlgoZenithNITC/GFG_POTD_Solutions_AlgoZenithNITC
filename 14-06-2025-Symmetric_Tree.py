class Solution:
    def isSymmetric(self, root):
        if root is None:
            return True
        return self.recsym(root.left, root.right)

    def recsym(self, p, q):
        if p is None and q is None:
            return True
        if p is None or q is None or p.data != q.data:
            return False
        return self.recsym(p.left, q.right) and self.recsym(p.right, q.left)
