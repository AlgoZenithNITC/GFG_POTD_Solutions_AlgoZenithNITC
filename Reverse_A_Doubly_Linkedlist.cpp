class Solution{
    public:
    Node* reverseDLL(Node *head){
        if(!head -> next){
            return head;
        }
        Node *current = head;
        Node *temp = NULL;
        while(current){
            temp = current -> prev;
            current -> prev = current -> next;
            current -> next = temp;
            current = current -> prev;
        }
        return temp -> prev;
    }
};
