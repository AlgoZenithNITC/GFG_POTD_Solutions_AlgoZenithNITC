class Solution:
    def root1_nodes(self, mp, root1):
        if root1 is None:
            return
        mp[root1.data] = mp.get(root1.data, 0) + 1
        self.root1_nodes(mp, root1.left)
        self.root1_nodes(mp, root1.right)

    def root2_nodes(self, mp, root2, ans):
        if root2 is None:
            return
        self.root2_nodes(mp, root2.left, ans)
        if root2.data in mp:
            ans.append(root2.data)
        self.root2_nodes(mp, root2.right, ans)
        
    def findCommon(self, root1, root2):
        mp = {}
        self.root1_nodes(mp, root1)
        ans = []
        self.root2_nodes(mp, root2, ans)
        return ans
