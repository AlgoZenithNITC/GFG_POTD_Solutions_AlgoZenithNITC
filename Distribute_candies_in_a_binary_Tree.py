class Solution:
    def solve(self, root):
        if root is None:
            return 0, 0
        left_profit, a1 = self.solve(root.left)
        right_profit, a2 = self.solve(root.right)
        ans = abs(left_profit) + abs(right_profit)
        return root.data + left_profit + right_profit - 1, ans + a1 + a2
    def distributeCandy(self, root):
        _, ans = self.solve(root)
        return ans
