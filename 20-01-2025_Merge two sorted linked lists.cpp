class Solution {
  public:
    Node* sortedMerge(Node* head1, Node* head2) {
        // code here
        Node*head3=nullptr;
        Node*temp=nullptr;
        while(head1!=NULL&&head2!=NULL){
            if(head3==nullptr){
                if(head1->data>head2->data){
                    head3=head2;
                    head2=head2->next;
                }
                else{
                    head3=head1;
                     head1=head1->next;
                }
                temp=head3;
            }
            else{
               if(head1->data>head2->data){
                   temp->next=head2;
                   head2=head2->next;
               }
                else{
                    temp->next=head1;
                     head1=head1->next;
                }
                temp=temp->next;
            }
        }
        if(head1!=NULL){
            temp->next=head1;
        }
        else if(head2!=NULL){
            temp->next=head2;
        }
        return head3;
    }
};