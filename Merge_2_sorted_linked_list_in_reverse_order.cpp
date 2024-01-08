class Solution{
    public:
    struct Node * mergeResult(Node *node1, Node *node2){
        if(node1 == NULL and node2 == NULL){
            return NULL;
        }
        Node *present = NULL;
        while(node1 != NULL and node2 != NULL){
            if(node1 -> data <= node2 -> data){
                Node *temp = node1 -> next;
                node1 -> next = present;
                present = node1;
                node1 = temp;
            }else{
                Node *temp = node2 -> next;
                node2 -> next = present;
                present = node2;
                node2 = temp;
            }
        }
        while(node1 != NULL){
            Node *temp = node1 -> next;
            node1 -> next = present;
            present = node1;
            node1 = temp;
        }
        while(node2 != NULL){
            Node *temp = node2 -> next;
            node2 -> next = present;
            present = node2;
            node2 = temp;
        }
        return present;
    }  
};
