class Solution:
    def bottomView(self,root):
        if not root:
            return []
    
        queue = deque([root])
        hd_node_map = {}
        node_hd_map = {root: 0}
    
        while queue:
            temp = queue.popleft()
            hd = node_hd_map[temp]
    
            hd_node_map[hd] = temp.data
    
            if temp.left:
                queue.append(temp.left)
                node_hd_map[temp.left] = hd - 1
            if temp.right:
                queue.append(temp.right)
                node_hd_map[temp.right] = hd + 1
    
        result = [hd_node_map[hd] for hd in sorted(hd_node_map)]
        return result
