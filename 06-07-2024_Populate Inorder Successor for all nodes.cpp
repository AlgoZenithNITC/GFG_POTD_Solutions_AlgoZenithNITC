class Solution {
  public:
    // Recursive function to populate the next pointer in the inorder traversal
    void populateNextRecur(Node *p, Node **next_ref) {
        // If p is not NULL
        if (p) {
            // Traverse to the right subtree first
            populateNextRecur(p->right, next_ref);

            // Set the next pointer of p to the current value of next_ref
            p->next = *next_ref;

            // Update the value of next_ref to p
            *next_ref = p;

            // Traverse to the left subtree
            populateNextRecur(p->left, next_ref);
        }
    }

    // Function to populate the next pointer in each node
    void populateNext(Node *root) {
        // Initialize next pointer as NULL
        Node *next = NULL;

        // Call the recursive function
        populateNextRecur(root, &next);
    }
};
