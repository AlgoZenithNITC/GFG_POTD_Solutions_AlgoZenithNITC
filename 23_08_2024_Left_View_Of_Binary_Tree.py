#User function Template for python3


'''
# Node Class:
class Node:
    def _init_(self,val):
        self.data = val
        self.left = None
        self.right = None
'''

#Function to return a list containing elements of left view of the binary tree.
def LeftView(root):
    stack=[]
    mpp={}
    stack.append((root,0))
    while stack:
        pair=stack.pop()
        node=pair[0]
        y=pair[1]
        if y not in mpp:
            mpp[y]=node.data
        if node.right: stack.append((node.right,y+1))
        if node.left: stack.append((node.left,y+1))
    res=[]
    res = [mpp[key] for key in sorted(mpp)]
    return res
