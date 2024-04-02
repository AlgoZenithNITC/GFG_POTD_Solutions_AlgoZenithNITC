# class Node:
#     def __init__(self):
#         self.data = None
#         self.left = None
#         self.right = None
import sys         
class Solution:
    def absolute_diff(self, root):
        self.res = sys.maxsize
        self.prev = 0
        self.find(root)
        return self.res

    def find(self, root):
        if not root:
            return

        self.find(root.left)
        if self.prev > 0:
            self.res = min(self.res, abs(root.data - self.prev))
        self.prev = root.data
        self.find(root.right)

