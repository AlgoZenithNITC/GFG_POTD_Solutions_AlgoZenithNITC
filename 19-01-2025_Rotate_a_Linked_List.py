class Solution:
    def rotate(self, head: Node, k: int) -> Node:
        if not head or not head.next or k == 0:
            return head
        
        # Count the number of nodes
        count = 1
        tail = head
        while tail.next:
            tail = tail.next
            count += 1
        
        # Effective rotations
        k %= count
        if k == 0:
            return head
        
        # Find the new head
        current = head
        for _ in range(count - k - 1):
            current = current.next
        
        # Rotate the list
        new_head = current.next
        current.next = None
        tail.next = head
        
        return new_head
