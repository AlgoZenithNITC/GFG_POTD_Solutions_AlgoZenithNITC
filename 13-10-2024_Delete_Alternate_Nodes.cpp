// Function to delete alternate nodes in a linked list
class Solution {
  public:
    void deleteAlt(struct Node *head) {
        // If the list is empty, return
        if (head == NULL)
            return;

        // Initialize two pointers, prev and node, to keep track of current and next
        // nodes
        struct Node *prev = head;
        struct Node *node = head->next;

        // Iterate through the list and delete alternate nodes
        while (prev != NULL && node != NULL) {
            // Point the previous node to the next next node
            prev->next = node->next;

            // Free the memory of the current node
            free(node);

            // Update the previous and node pointers
            prev = prev->next;
            if (prev != NULL)
                node = prev->next;
        }
    }
};
