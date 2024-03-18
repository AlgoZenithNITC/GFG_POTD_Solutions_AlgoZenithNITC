class Solution:
    def levelOrder(self,root):
        queue = deque([root])
        res = []
        while queue:
            node = queue.popleft()
            res.append(node.data)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return res
