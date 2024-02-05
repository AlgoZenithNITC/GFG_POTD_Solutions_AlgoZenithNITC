'''
class Node: 
    # Constructor to initialize the node object 
    def __init__(self, data): 
        self.data = data 
        self.next = None
  '''
class Solution:
    def sortedInsert(self, head, data):
        #code here
        new_node=Node(data)
        current=head
        
        if current is None:
            new_node.next=new_node
            head=new_node
            return head
            
        elif current.data >= new_node.data: 
            while current.next != head:
                current=current.next
    
            
            current.next=new_node
            new_node.next=head
            return new_node
        
        
        else: 
            while (current.next != head  and current.next.data < new_node.data): 
                current = current.next
    
            new_node.next = current.next
            current.next = new_node
            return head
        
