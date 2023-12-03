class Solution:
    def countPairs(self, root1, root2, x): 
        if root1 is None or root2 is None:
            return 0
        bst1, bst2 = [], []
        count = 0
        while True:
            while root1:
                bst1.append(root1)
                root1 = root1.left
            while root2:
                bst2.append(root2)
                root2 = root2.right
            if not bst1 or not bst2:
                break
            top1 = bst1[-1]
            top2 = bst2[-1]
            if top1.data + top2.data == x:
                count += 1
                bst1.pop()
                bst2.pop()
                root1 = top1.right
                root2 = top2.left
            elif top1.data + top2.data < x:
                bst1.pop()
                root1 = top1.right
            else:
                bst2.pop()
                root2 = top2.left
        return count
