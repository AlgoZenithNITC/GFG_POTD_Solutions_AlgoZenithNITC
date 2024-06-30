class Solution {
  public:
    // Function to delete a node at given position.
    Node *deleteNode(struct Node *head_ref, int x) {
        // initializing del node with head_ref.
        struct Node *del = head_ref;
        x = x - 1;

        // iterating till the position given in parameter.
        while (x--)
            del = del->next;

        /* base case */
        // if head_ref or del is null, return null.
        if (head_ref == NULL || del == NULL)
            return NULL;

        /* If Node to be deleted is head Node */
        // if del is equal to head_ref, update head_ref to next node.
        if (head_ref == del)
            head_ref = del->next;

        /* Change next only if Node to be deleted is NOT the last Node */
        // if del next is not null, update previous node of del next to del previous.
        if (del->next != NULL)
            del->next->prev = del->prev;

        /* Change prev only if Node to be deleted is NOT the first Node */
        // if del previous is not null, update next node of del previous to del next.
        if (del->prev != NULL)
            del->prev->next = del->next;

        /* Finally, free the memory occupied by del*/
        // free up the memory of del node.
        free(del);
        // return updated head_ref.
        return head_ref;
    }
};
