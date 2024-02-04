class Solution:
   def subLinkedList(self, l1, l2):
        
        def linkedListToDecimal(head):
            val = ""
            while head:
                val += str(head.data)
                head = head.next
            
            return int(val)
            
        return Node(abs(linkedListToDecimal(l1) - linkedListToDecimal(l2)))
