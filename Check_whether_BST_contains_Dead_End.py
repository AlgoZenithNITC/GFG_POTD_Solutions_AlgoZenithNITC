class Solution:
    def has_dead_end(self, root, min_val, max_val):
        if root is None:
            return False
        if min_val == max_val:
            return True
        return self.has_dead_end(root.left, min_val, root.data - 1) or self.has_dead_end(root.right, root.data + 1, max_val)

    def isDeadEnd(self, root):
        return self.has_dead_end(root, 1, 10001)
