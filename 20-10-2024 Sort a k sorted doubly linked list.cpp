class Compare {
    public:
        bool operator()(Node* a, Node* b) {
           return a->data > b->data;
        }
};

// function to sort a k sorted doubly linked list
Node* sortAKSortedDLL(Node* head, int k) {
    
    // if list is empty
    if (head == nullptr)
        return head;

    // priority_queue 'pq' implemented as min heap with the
    // help of 'compare' function
    priority_queue<Node*, vector<Node*>, Compare> pq;

    Node* newHead = nullptr, *last = nullptr;

    // Create a Min Heap of first (k+1) elements from
    // input doubly linked list
    for (int i = 0; head != NULL && i < k+1; i++) {
        pq.push(head);

        head = head->next;
    }

    while (!pq.empty()) {

        if (newHead == nullptr) {
            newHead = pq.top();
            newHead->prev = nullptr;

            // 'last' points to the last node
            // of the result sorted list so far
            last = newHead;
        }

        else {
            last->next = pq.top();
            pq.top()->prev = last;
            last = pq.top();
        }

        // remove element from 'pq'
        pq.pop();

        // if there are more nodes left 
          // in the input list
        if (head != nullptr) {
            pq.push(head);
            head = head->next;
        }
    }

    // making 'next' of last node point to NULL
    last->next = nullptr;

    // new head of the required sorted DLL
    return newHead;
}
