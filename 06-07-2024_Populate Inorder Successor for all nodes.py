from collections import deque


class Node:

    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None
        self.next = None


class Solution:
    #Recursive function to populate the next pointer for each node
    def populateNextRecur(self, p):
        if p:
            #First recursively populate the next pointer for right subtree
            self.populateNextRecur(p.right)

            #Set the next pointer of the current node as the previous node
            p.next = self.next
            #Update the previous node as the current node
            self.next = p

            #Recursively populate the next pointer for left subtree
            self.populateNextRecur(p.left)

    #Function to populate the next pointer
    def populateNext(self, root):
        #Initialize the next pointer as None
        self.next = None

        #Call the recursive function to populate the next pointer
        self.populateNextRecur(root)
