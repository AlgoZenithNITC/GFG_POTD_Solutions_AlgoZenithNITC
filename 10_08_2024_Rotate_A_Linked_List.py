class Solution:
    
    #Function to rotate a linked list.
    def rotate(self, head, k):
        # code here
        x=head
        n=0
        while x:
            x=x.next
            n+=1
        if k==n:
            return head
        
        c=0
        x=head
        
        while c!=k-1:
            x=x.next
            c+=1
            
        nxt=x.next
        x.next=None
        y=nxt
        while y.next:
            y=y.next
        
        y.next=head
        head=nxt
        
        return head
