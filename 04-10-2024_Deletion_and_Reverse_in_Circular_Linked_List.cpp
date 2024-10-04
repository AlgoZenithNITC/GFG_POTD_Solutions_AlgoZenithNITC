class Solution {
  public:
    // Function to reverse a circular linked list
    Node* reverse(Node* head) {
        if (head == NULL || head->next == head)
            return head;

        Node* prev = NULL;
        Node* current = head;
        Node* next;
        Node* init = head;

        do {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        } while (current != init);

        head->next = prev;
        head = prev;
        return head;
    }

    // Function to delete a node from the circular linked list
    Node* deleteNode(Node* head, int key) {
        if (head == NULL)
            return head;

        Node* current = head;
        Node* prev = NULL;

        // Finding the node to delete
        while (current->data != key) {
            if (current->next == head) {
                // Node with key not found in the list
                return head;
            }
            prev = current;
            current = current->next;
        }

        // Case 1: Only one node in the list
        if (current == head && current->next == head) {
            head = NULL;
            return head;
        }

        // Case 2: Deleting the head node
        if (current == head) {
            prev = head;
            while (prev->next != head) {
                prev = prev->next;
            }
            head = current->next;
            prev->next = head;
        }
        // Case 3: Deleting the last node
        else if (current->next == head) {
            prev->next = head;
        }
        // Case 4: Deleting a node in between
        else {
            prev->next = current->next;
        }

        return head;
    }
};
