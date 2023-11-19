class Solution{
    public:
    Node* findIntersection(Node* head1, Node* head2){
        Node* answer = new Node(0);
        Node* temp = answer;
        while(head1 && head2){
            if(head1 -> data < head2 -> data){
                head1 = head1 -> next;
            }
            else if(head1 -> data > head2 -> data){
                head2 = head2 -> next;
            }
            else{
                answer -> next = head1;
                answer = answer -> next;
                head1 = head1 -> next;
                head2 = head2 -> next;
            }
        }
        answer -> next = NULL;
        return temp -> next;
    }
};
