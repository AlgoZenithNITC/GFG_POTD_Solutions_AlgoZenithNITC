class Solution:
    def check(self, root):
        if not root:
            return True
        
        queue = deque([(root, 0)])
        first_leaf_level = None
        
        while queue:
            node, level = queue.popleft()
            
            if not node.left and not node.right:
                if first_leaf_level is None:
                    first_leaf_level = level
                elif level != first_leaf_level:
                    return False
            
            if node.left:
                queue.append((node.left, level + 1))
            
            if node.right:
                queue.append((node.right, level + 1))
        
        return True
