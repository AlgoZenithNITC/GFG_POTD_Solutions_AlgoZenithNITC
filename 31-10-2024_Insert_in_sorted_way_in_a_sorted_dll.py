class Solution:
    def sortedInsert(self, head, x):
        new_node = Node(x)
        
        if head is None:
            return new_node
        
        # If the new node needs to be inserted before the head
        if head.data >= x:
            new_node.next = head
            head.prev = new_node
            return new_node
        
        prev = None
        temp = head
        
        while temp:
            if temp.data < x:
                prev = temp
                temp = temp.next
            else:
                # Insert the new node before temp
                new_node.prev = prev
                new_node.next = temp
                
                if prev:
                    prev.next = new_node
                if temp:
                    temp.prev = new_node
                
                return head
        
        # If we reached the end, append the new node
        prev.next = new_node
        new_node.prev = prev
        
        return head
