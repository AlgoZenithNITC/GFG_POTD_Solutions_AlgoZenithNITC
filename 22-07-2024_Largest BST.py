class Node1:

    def __init__(self, isbst, size, mn, mx):
        self.isbst = isbst
        self.size = size
        self.mn = mn
        self.mx = mx


class Solution:

    def bst(self, root):
        if root is None:
            return Node1(True, 0, float('inf'), float('-inf'))

        left = self.bst(root.left)
        right = self.bst(root.right)

        if left.isbst and right.isbst and root.data > left.mx and root.data < right.mn:
            return Node1(True, 1 + left.size + right.size,
                         min(root.data, left.mn), max(root.data, right.mx))
        else:
            return Node1(False, max(left.size, right.size), float('inf'),
                         float('-inf'))

    def largestBst(self, root):
        return self.bst(root).size
