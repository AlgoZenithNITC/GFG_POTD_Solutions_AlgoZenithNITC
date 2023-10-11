class Solution:
    def __init__(self):
        self.mp = {}
    def structure(self, root):
        if root is None:
            return ""
        path = self.structure(root.left) + str(root.data) + self.structure(root.right)
        if path in self.mp:
            self.mp[path] += 1
        else:
            self.mp[path] = 1
        return path
    def dupSub(self, root):
        result = self.structure(root)
        for key, value in self.mp.items():
            if len(key) > 2 and value > 1:
                return 1
        return 0
