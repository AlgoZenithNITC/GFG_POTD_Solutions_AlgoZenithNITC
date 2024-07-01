# User function Template for python3

'''
class ListNode:

    # Constructor to create a new node
    def __init__(self, data):
        self.data = data
        self.next = None


# Tree Node structure
class Tree:

    # Constructor to create a new node
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

'''

#Function to make binary tree from linked list.
def convert(head):
    arr = []
    while head:
        arr.append(head.data)
        head = head.next
    
    # Helper function to create the binary tree
    def fun(arr, i):
        if i >= len(arr):
            return None
        
        root = Tree(arr[i])
        root.left = fun(arr, 2 * i + 1)
        root.right = fun(arr, 2 * i + 2)
        
        return root
    
    return fun(arr, 0)
