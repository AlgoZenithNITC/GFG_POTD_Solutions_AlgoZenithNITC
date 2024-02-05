class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node sortedInsert(Node head, int data) {
        Node new_node = new Node(data);
        Node current = head;
        if (current == null) {
            new_node.next = new_node;
            head = new_node;
            return head;
        } else if (current.data >= new_node.data) {
            while (current.next != head) {
                current = current.next;
            }
            current.next = new_node;
            new_node.next = head;
            return new_node;
        } else {
            while (current.next != head && current.next.data < new_node.data) {
                current = current.next;
            }
            new_node.next = current.next;
            current.next = new_node;
            return head;
        }
    }
}


