class Solution:
    def reverseDLL(self, head):
        if head.next is None:
            return head
        current = head
        temp = None
        while current is not None:
            temp = current.prev
            current.prev = current.next
            current.next = temp
            current = current.prev
        return temp.prev
