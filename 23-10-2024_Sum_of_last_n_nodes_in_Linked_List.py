class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def sumOfLastN_Nodes(self, head: Node, n: int) -> int:
        sum = 0
        count = 0
        ptr = head
        
        # Count the total number of nodes in the list
        while ptr is not None:
            ptr = ptr.next
            count += 1

        # Move the pointer to the (count - n)th node
        i = 0
        ptr = head
        while i < count - n:
            ptr = ptr.next
            i += 1

        # Sum the last n nodes
        for i in range(n):
            sum += ptr.data
            ptr = ptr.next
        
        return sum
