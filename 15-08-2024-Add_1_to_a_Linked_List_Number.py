#Back-end complete function Template for Python 3


class Solution:

    def reverse(self, head):
        # this function reverses the linked list
        prev = None
        current = head
        next = head.next

        while current is not None:
            next = current.next  # storing next node
            current.next = prev  # linking current node to previous
            prev = current  # updating prev
            current = next  # updating current

        return prev

    def addOne(self, head):
        head = self.reverse(head)  # reversing list to make addition easy

        current = head
        carry = 1

        while (carry):
            current.data += 1  # adding one to current node

            if current.data < 10:
                return self.reverse(head)
                # if no carry we can reverse back list and return it
            else:
                current.data = 0
                # else we continue with taking carry forward

            if current.next is None:
                break
                # if end of list, we break from loop
            else:
                current = current.next
                # else we move to next node

        current.next = Node(1)  # adding new node for the carried 1
        return self.reverse(head)
