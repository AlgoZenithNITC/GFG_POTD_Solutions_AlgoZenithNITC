

/*
Structure of linked list is as
struct Node
{
    int data;
    struct Node* npx;

    Node(int x){
        data = x;
        npx = NULL;
    }
};

Utility function to get XOR of two Struct Node pointer
use this function to get XOR of two pointers
struct Node* XOR (struct Node *a, struct Node *b)
{
    return (struct Node*) ((uintptr_t) (a) ^ (uintptr_t) (b));
}
*/

// function should insert the data to the front of the list
struct Node *insert(struct Node *head, int data) {
    // Code here
    struct Node *newHead = new Node( data );
    newHead->npx = XOR( NULL, head );
    if( head )
        head->npx = XOR( newHead, XOR( NULL, head->npx ) );
    return newHead;
}

vector<int> getList(struct Node *head) {
    // Code here
     struct Node *prev, *next;
    prev = NULL;
    vector<int> res;
    while( head ) {
        res.push_back( head->data );
        next = XOR( head->npx, prev );
        prev = head;
        head = next;
    }
    return res;
    
}
