# Back-end complete function Template for Python 3


# Linked List class
class Solution:

    def deleteAlt(self, head):
        if not head:
            return

        prev = head
        node = head.next

        while prev and node:
            prev.next = node.next
            node = prev.next
            if node:
                prev = node
                node = node.next
