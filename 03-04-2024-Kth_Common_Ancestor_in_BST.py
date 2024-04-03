from typing import Optional

# A Tree node
class Node:
    def __init__(self, data: int, left: Optional['Node'] = None, right: Optional['Node'] = None):
        self.data = data
        self.left = left
        self.right = right

class Solution:
    def kthCommonAncestor(self, root: Optional[Node], k: int, x: int, y: int) -> int:
        def fun(node: Optional[Node], x: int, y: int, k: int) -> int:
            if not node:
                return -1
            
            val = -1
            if node.data > x and node.data > y:
                val = fun(node.left, x, y, k)
            elif node.data < x and node.data < y:
                val = fun(node.right, x, y, k)
            
            k -= 1
            if k == 0:
                val = node.data
            
            return val
        
        return fun(root, x, y, k)

