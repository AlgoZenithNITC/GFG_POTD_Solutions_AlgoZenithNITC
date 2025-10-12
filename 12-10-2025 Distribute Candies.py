# Node Structure
class Node:
    def __init__(self, x):
        self.data = x
        self.left = None
        self.right = None

# function to find the number of
# moves to distribute all of the candies
def distCandyUtil(root, ans):
    
    if root is None:
        return 0

    # Traverse left subtree
    l = distCandyUtil(root.left, ans)

    # Traverse right subtree
    r = distCandyUtil(root.right, ans)

    ans[0] += abs(l) + abs(r)

    # Return number of moves to balance
    # current node
    return root.data + l + r - 1

# Function to find the number of moves 
def distCandy(root):
    ans = [0]
    
    distCandyUtil(root, ans)
    
    return ans[0]

if __name__ == "__main__":
    
       #  Representation of given Binary Tree
    #         5
    #        / \
    #       0   0
    #          / \
    #         0   0
    root = Node(5)
    root.left = Node(0)
    root.right = Node(0)
    root.right.left = Node(0)
    root.right.right = Node(0)

    print(distCandy(root))
