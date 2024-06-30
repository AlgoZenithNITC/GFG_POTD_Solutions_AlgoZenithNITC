class Solution:

    def delete_node(self, head, x):
        del_node = head
        x -= 1
        while x > 0:
            del_node = del_node.next
            x -= 1

        # base case
        if head is None or del_node is None:
            return None

        # If Node to be deleted is head Node
        if head == del_node:
            head = del_node.next

        # Change next only if Node to be deleted is NOT the last Node
        if del_node.next is not None:
            del_node.next.prev = del_node.prev

        # Change prev only if Node to be deleted is NOT the first Node
        if del_node.prev is not None:
            del_node.prev.next = del_node.next

        # return updated head
        return head
