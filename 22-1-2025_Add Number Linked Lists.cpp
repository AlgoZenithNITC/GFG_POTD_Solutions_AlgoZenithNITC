class Solution {
  public:
    Node* addTwoLists(Node* num1, Node* num2) {
        Node* l1 = reverseList(num1);
        Node* l2 = reverseList(num2);
        Node* curr = nullptr;
        int carry = 0;

        while (l1 != nullptr || l2 != nullptr || carry > 0) {
            int v1 = (l1 != nullptr) ? l1->data : 0;
            int v2 = (l2 != nullptr) ? l2->data : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            Node* tmp = new Node(sum % 10);
            tmp->next = curr;
            curr = tmp;

            if (l1 != nullptr) l1 = l1->next;
            if (l2 != nullptr) l2 = l2->next;
        }

        while (curr != nullptr && curr->data == 0) {
            curr = curr->next;
        }

        return curr;
    }

  private:
    Node* reverseList(Node* head) {
        Node* tmpHead = nullptr;

        while (head != nullptr) {
            Node* nex = head->next;
            if (tmpHead == nullptr) {
                tmpHead = head;
                tmpHead->next = nullptr;
            } else {
                head->next = tmpHead;
                tmpHead = head;
            }
            head = nex;
        }

        return tmpHead;
    }
};
