class Solution:

    def inorder(self, root, arr):
        if not root:
            return
        self.inorder(root.left, arr)
        arr.append(root.data)
        self.inorder(root.right, arr)

    def merge(self, root1, root2):
        arr = []
        self.inorder(root1, arr)
        self.inorder(root2, arr)
        arr.sort()
        return arr
