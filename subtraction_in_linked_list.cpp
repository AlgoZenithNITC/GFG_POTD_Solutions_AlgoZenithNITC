class Solution {
public:

    int size(Node * head){
        int count =0;
        for(Node* curr=head;curr!=NULL;curr=curr->next)
         count++;
         
        return count; 
    }
    
    Node* reverselist(Node* head){
        
        Node *prev=NULL,*curr=head,*next=NULL;
        while(curr!=NULL){
          next=curr->next;
          curr->next=prev;
          prev=curr;
          curr=next;
        }
        
        return prev;
    }
    
    Node* remove_leading_zero(Node* head){
        while(head!=NULL&&head->data==0) head=head->next;
        
        return head;
    }

    Node* subLinkedList(Node* head1, Node* head2) {
        // Your implementation of subLinkedList goes here
        // Make sure to return the head of the resulting linked list
        head1=remove_leading_zero(head1);
        head2=remove_leading_zero(head2);
        
        int n1=size(head1),n2=size(head2);
        if(n1==0&&n2==0) return new Node(0);
        
        if(n2>n1){
            Node* temp=head1;
            head1=head2;
            head2=temp;
        }
        
        if(n1==n2){
            Node *curr1=head1 , *curr2=head2;
            while(curr1->data==curr2->data){
                curr1 = curr1->next;
                curr2 = curr2->next;
                if(curr1==NULL) return new Node(0);
            }
            
            if(curr2->data>curr1->data){
                Node* temp=head1;
                head1=head2;
                head2=temp; 
            }
        }
        
        head1=reverselist(head1);
        head2=reverselist(head2);
            
        Node* res=NULL;
        while(head1!=NULL){
           int d1=head1->data , d2=0;
           if(head2!=NULL) d2=head2->data;
           
           if(d1<d2){
               if(head1->next!=NULL) head1->next->data-=1;
               d1+=10;
           }
           Node* temp = new Node(d1-d2);
           temp->next=res;
           res=temp;
           
           head1=head1->next;
           if(head2!=NULL) head2=head2->next;
        }
        
        res=remove_leading_zero(res);
        
        return res;
    }
};
