class Solution:
    
    def reverse(self, head):
        if head is None or head.next == head:
            return head

        prev = None
        current = head
        init = head

        while True:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
            if current == init:
                break

        head.next = prev
        return prev

    def deleteNode(self, head, key):
        if head is None:
            return head

        current = head
        prev = None

        if current.data == key:
            if head.next == head:
                return None
            while current.next != head:
                current = current.next
            current.next = head.next
            return current.next

        while current.next != head and current.data != key:
            prev = current
            current = current.next

        if current.data == key:
            prev.next = current.next

        return head
