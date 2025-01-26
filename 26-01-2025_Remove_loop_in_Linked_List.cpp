class Solution 
{
  public:
    // Function to remove a loop in the linked list.
    void removeLoop(Node* head) 
    {
        
    // hash set to hash addresses of
    // the linked list nodes
    unordered_set<Node *> st;

    // pointer to prev node
    Node *prev = nullptr;
    while (head != nullptr) 
    {

        if (st.find(head) == st.end()) 
        {
            st.insert(head);
            prev = head;
            head = head->next;
        }

        else 
        {
            prev->next = nullptr;
            break;
        }
    }
    }
};