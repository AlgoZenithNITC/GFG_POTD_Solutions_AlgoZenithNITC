def reverse(self, head):
    prev = None
    curr = head

    while curr:
        next_node = curr.next

        curr.next = prev
        curr.prev = next_node

        prev = curr
        curr = next_node

    return prev
