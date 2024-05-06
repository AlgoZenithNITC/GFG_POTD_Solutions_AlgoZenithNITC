from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def verticalSumCal(self, root: TreeNode, v: List[int], val: int) -> None:
        if not root:
            return
        v[val] += root.val
        self.verticalSumCal(root.left, v, val - 1)
        self.verticalSumCal(root.right, v, val + 1)

    def verticalSum(self, root: TreeNode) -> List[int]:
        v = [0] * 20000
        self.verticalSumCal(root, v, 10000)
        return [x for x in v if x != 0]

