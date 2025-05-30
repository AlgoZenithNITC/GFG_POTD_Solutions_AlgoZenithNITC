def findMaxFork(self, root, k):
    ans = -1
    curr = root
    while curr is not None:
        if k < curr.data:
            curr = curr.left
        else:
            ans = curr.data
            curr = curr.right
    
    return ans
