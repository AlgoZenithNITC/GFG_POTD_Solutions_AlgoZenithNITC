class Solution {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Count the number of nodes
        int count = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }

        // Effective rotations
        k %= count;
        if (k == 0) {
            return head;
        }

        // Find the new head
        Node current = head;
        for (int i = 1; i < count - k; i++) {
            current = current.next;
        }

        // Rotate the list
        Node newHead = current.next;
        current.next = null;
        tail.next = head;

        return newHead;
    }
}
