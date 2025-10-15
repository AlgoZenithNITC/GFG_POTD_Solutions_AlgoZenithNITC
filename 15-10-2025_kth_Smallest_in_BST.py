class Solution:
    def __init__(self):
        self.lmao = 1

    def kthSmallest(self, root, k):
        if not root:
            return -1

        res = self.kthSmallest(root.left, k)
        if res != -1:
            return res

        if self.lmao == k:
            return root.data
        else:
            self.lmao += 1

        res = self.kthSmallest(root.right, k)
        return res
