class Solution:
    def Paths(self, root):
        def solve(node, curr, ans):
            if not node:
                return
            curr.append(node.data)
            if not node.left and not node.right:
                ans.append(curr[:])
                return
            solve(node.left, curr, ans)
            solve(node.right, curr, ans)
            curr.pop()

        ans = []
        curr = []
        solve(root, curr, ans)
        return ans

