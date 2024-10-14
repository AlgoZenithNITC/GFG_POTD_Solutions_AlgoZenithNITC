
class Solution:
    # Function to count nodes of a linked list.
    def getCount(self, head):
        count = 0

        # using a pointer for the linked list.
        current = head

        # using a loop to count nodes until we get null in link part of node.
        while current is not None:
            # updating counter.
            count += 1

            # updating pointer to the next node.
            current = current.next

        # returning the number of nodes.
        return count
