from collections import deque
import math

class Node:
    def __init__(self, x):
        self.data = x
        self.left = None
        self.right = None

class Solution:
    def isDeadEnd(self, root):
        if not root:
            return False

        q = deque()
        q.append((root, 1, int(1e5)))

        while q:
            cur, min_val, max_val = q.popleft()
            if not cur.left and not cur.right:
                if min_val == max_val:
                    return True
            if cur.left:
                q.append((cur.left, min_val, cur.data - 1))
            if cur.right:
                q.append((cur.right, cur.data + 1, max_val))
        return False
