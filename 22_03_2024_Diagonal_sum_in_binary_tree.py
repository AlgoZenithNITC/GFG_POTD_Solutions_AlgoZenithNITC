class Solution:
    def solve(self, root, mp, verticaldis):
        if root is None:
            return
        mp[verticaldis] = mp.get(verticaldis, 0) + root.data
        self.solve(root.left, mp, verticaldis + 1)
        self.solve(root.right, mp, verticaldis)

    def diagonalSum(self, root):
        mp = {}
        ans = []
        verticaldis = 0
        self.solve(root, mp, 0)
        for key, value in mp.items():
            if value > 0:
                ans.append(value)
        return ans

