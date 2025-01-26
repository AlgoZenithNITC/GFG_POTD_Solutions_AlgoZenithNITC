class Solution:
    # Function to remove a loop in the linked list.
    def removeLoop(self, head):
        # Function to detect and remove loop from linked list
        nodeSet = set()
        prev = None
        while head:
            # If node is already in the set, remove the loop
            if head in nodeSet:
                prev.next = None
                return
            
            # Add node to the set and move forward
            nodeSet.add(head)
            prev = head
            head = head.next
