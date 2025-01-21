class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head:
            return head
        
        current = head
        new_head = None
        tail = None

        while current:
            group_head = current
            prev = None
            next_node = None
            count = 0

            # Reverse k nodes
            while current and count < k:
                next_node = current.next
                current.next = prev
                prev = current
                current = next_node
                count += 1
            
            if new_head is None:
                new_head = prev
            
            if tail:
                tail.next = prev
            
            tail = group_head
        
        return new_head
