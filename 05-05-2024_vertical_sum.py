#User function Template for python3

'''
# Node Class:
class Node:
    def __init__(self,val):
        self.data = val
        self.left = None
        self.right = None
'''
class Solution:
    def __init__(self):
        self.offset = 10001  # Equivalent to 1e4+1 in C++

    def solve(self, root, l, mp):
        if root is None:
            return

        self.solve(root.left, l - 1, mp)

        if self.offset + l not in mp:
            mp[self.offset + l] = root.data
        else:
            mp[self.offset + l] += root.data

        self.solve(root.right, l + 1, mp)

    def verticalSum(self, root):
        mp = {}
        self.solve(root, 0, mp)

        # Sort the map keys to get the vertical sums in correct order
        sorted_keys = sorted(mp.keys())
        
        # Extract the vertical sums in the correct order
        return [mp[key] for key in sorted_keys]
