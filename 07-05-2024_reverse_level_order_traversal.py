#User function Template for python3

'''
class Node:
    def __init__(self,val):
        self.data = val
        self.left = None
        self.right = None
'''
from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def solve(root, ans):
    if root is None:
        return
    q = deque()
    q.append(root)
    
    while q:
        n = len(q)
        for i in range(n):
            temp = q.popleft()
            ans.append(temp.data)
            if temp.right:
                q.append(temp.right)
            if temp.left:
                q.append(temp.left)

def reverseLevelOrder(root):
    ans = []
    solve(root, ans)
    ans.reverse()
    return ans

