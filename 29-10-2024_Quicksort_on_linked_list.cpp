class Solution {
  public:
    struct Node* quickSort(struct Node* head) {
        // code here
        if (!head || !head->next)
        return head;

    int pivot = head->data;
    Node lessHead(0), equalHead(0), greaterHead(0);
    Node* lessTail = &lessHead, *equalTail = &equalHead, *greaterTail = &greaterHead;
    Node* current = head;

    while (current) {
        if (current->data < pivot) {
            lessTail->next = current;
            lessTail = lessTail->next;
        } else if (current->data == pivot) {
            equalTail->next = current;
            equalTail = equalTail->next;
        } else {
            greaterTail->next = current;
            greaterTail = greaterTail->next;
        }
        current = current->next;
    }

    lessTail->next = equalTail->next = greaterTail->next = nullptr;

    Node* sortedLess = quickSort(lessHead.next);
    Node* sortedGreater = quickSort(greaterHead.next);

    Node* sortedHead = sortedLess ? sortedLess : equalHead.next;
    Node* tail = sortedHead;

    while (tail && tail->next)
        tail = tail->next;

    if (tail) tail->next = equalHead.next;
    equalTail->next = sortedGreater;

    return sortedHead;
    }
};