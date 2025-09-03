Node *reverse(Node *head) {
    // code here
    Node *prev = NULL, *curr = head, *next = head->next;
    
    while(curr != NULL){
        next = curr->next;
        
        curr->next = prev;
        curr->prev = next;
        
        prev = curr;
        curr = next;
    }
    
    return prev;
}
