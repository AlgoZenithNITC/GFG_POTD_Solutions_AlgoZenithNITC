#User function Template for python3

class Solution:
    def get_time(self, root, target, ans):
        if not root:
            return (False, 0)
        
        left = self.get_time(root.left, target, ans)
        right = self.get_time(root.right, target, ans)
        
        if not left[0] and not right[0]:
            ans[0] = max(ans[0], max(left[1], right[1]))
            val = max(left[1], right[1])
            if root.data == target:
                return (True, 1)
            return (False, 1 + val)
        else:
            ans[0] = max(ans[0], left[1] + right[1])
            if left[0]:
                return (True, 1 + left[1])
            else:
                return (True, 1 + right[1])
    
    def minTime(self, root, target):
        # code here
        ans = [0]
        self.get_time(root, target, ans)
        return ans[0]
