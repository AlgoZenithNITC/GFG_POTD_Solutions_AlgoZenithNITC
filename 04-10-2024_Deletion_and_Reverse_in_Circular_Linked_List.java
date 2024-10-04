class Solution {
    
    Node reverse(Node head) {
        if (head == null || head.next == head) return head;

        Node prev = null;
        Node current = head;
        Node next;
        Node init = head;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != init);

        head.next = prev;
        head = prev;
        return head;
    }


    Node deleteNode(Node head, int key) {
        if (head == null) return head;

        Node current = head;
        Node prev = null;

        while (current.data != key) {
            if (current.next == head) {
                
                return head;
            }
            prev = current;
            current = current.next;
        }

        if (current == head && current.next == head) {
            head = null;
            return head;
        }

        if (current == head) {
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = current.next;
            prev.next = head;
        } else if (current.next == head) {
            prev.next = head;
        } else {
            prev.next = current.next;
        }
        return head;
    }
}
