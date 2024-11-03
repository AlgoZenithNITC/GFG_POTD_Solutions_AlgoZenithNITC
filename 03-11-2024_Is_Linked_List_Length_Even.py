class Solution:
    # your task is to complete this function
    # function should return false if length is even
    # else return true
    def isLengthEven(self, head):
        # Code here
        temp = head
        count = 0
        while temp is not None:
            temp = temp.next
            count += 1
        return count % 2 == 0


#{ 
 # Driver Code Starts
#main


class Node:
    # Constructor to initialize the node object
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    # Function to initialize head
    def __init__(self):
        self.head = None

    # Function to insert a new node at the beginning
    def push(self, new_data):
        new_node = Node(new_data)
        new_node.next = self.head
        self.head = new_node

    # Utility function to prit the linked LinkedList
    def printList(self):
        temp = self.head
        while (temp):
            print(temp.data, end=" ")
            temp = temp.next
        print("")


if __name__ == '__main__':
    t = int(input())
    while (t > 0):
        llist = LinkedList()
        values = input().strip().split()
        for i in reversed(values):
            llist.push(i)
        flag = Solution().isLengthEven(llist.head)
        if flag:
            print("true")
        else:
            print("false")
        print("~")
        t -= 1

# } Driver Code Ends
