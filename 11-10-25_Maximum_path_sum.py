class Solution:
    def helper(self, root, ans):
        if not root:
            return 0
        
        left = self.helper(root.left, ans)
        right = self.helper(root.right, ans)
        
        val = root.data + max(left, 0) + max(right, 0)
        ans[0] = max(ans[0], val)
        
        return root.data + max(left, right, 0)
    
    def findMaxSum(self, root):
        ans = [float('-inf')]
        self.helper(root, ans)
        return ans[0]
