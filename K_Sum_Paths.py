class Solution:
    def solve(self, root, k, total, sum, ending, mod):
        if root is None:
           return
        sum += root.data
        total[0] = (total[0] + ending.get(sum - k, 0)) % mod
        ending[sum] = ending.get(sum, 0) + 1
        Solution().solve(root.left, k, total, sum, ending, mod)
        Solution().solve(root.right, k, total, sum, ending, mod)
        ending[sum] -= 1
    def sumK(self,root,k):
        total = [0]
        mod = int(1e9) + 7
        ending = {0: 1}
        Solution().solve(root, k, total, 0, ending, mod)
        return total[0]
