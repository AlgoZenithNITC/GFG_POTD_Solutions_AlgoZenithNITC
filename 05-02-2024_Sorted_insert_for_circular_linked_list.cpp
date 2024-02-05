#include <iostream>

class Node {
public:
    int data;
    Node* next;

    Node(int val) : data(val), next(nullptr) {}
};

class Solution {
public:
    Node* sortedInsert(Node* head, int data) {
        Node* new_node = new Node(data);
        Node* current = head;

        if (current == nullptr) {
            new_node->next = new_node;
            head = new_node;
            return head;
        } else if (current->data >= new_node->data) {
            while (current->next != head) {
                current = current->next;
            }
            current->next = new_node;
            new_node->next = head;
            return new_node;
        } else {
            while (current->next != head && current->next->data < new_node->data) {
                current = current->next;
            }
            new_node->next = current->next;
            current->next = new_node;
            return head;
        }
    }
};
