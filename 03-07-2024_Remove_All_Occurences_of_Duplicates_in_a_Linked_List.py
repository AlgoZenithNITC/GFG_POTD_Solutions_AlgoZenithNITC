class Solution:
    def removeAllDuplicates(self, head):
        curr = head
        dummy = prev = Node(None)
        dummy.next = curr
        
        while curr:
            while curr.next and prev.next.data == curr.next.data:
                curr = curr.next
            
            if prev.next == curr:
                prev = prev.next
            
            else:
                prev.next = curr.next
            
            curr = curr.next
        
        head = dummy.next
        return head
