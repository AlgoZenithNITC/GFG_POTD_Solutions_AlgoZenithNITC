class Solution {
    int size(Node head) {
        int count = 0;
        for (Node curr = head; curr != null; curr = curr.next)
            count++;
        return count;
    }

    Node reverselist(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    Node removeLeadingZero(Node head) {
        while (head != null && head.data == 0) head = head.next;
        return head;
    }

    Node subLinkedList(Node head1, Node head2) {
        head1 = removeLeadingZero(head1);
        head2 = removeLeadingZero(head2);
        int n1 = size(head1), n2 = size(head2);
        if (n1 == 0 && n2 == 0) return new Node(0);
        if (n2 > n1) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        if (n1 == n2) {
            Node curr1 = head1, curr2 = head2;
            while (curr1.data == curr2.data) {
                curr1 = curr1.next;
                curr2 = curr2.next;
                if (curr1 == null) return new Node(0);
            }
            if (curr2.data > curr1.data) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
        }
        head1 = reverselist(head1);
        head2 = reverselist(head2);
        Node res = null;
        while (head1 != null) {
            int d1 = head1.data, d2 = 0;
            if (head2 != null) d2 = head2.data;
            if (d1 < d2) {
                if (head1.next != null) head1.next.data -= 1;
                d1 += 10;
            }
            Node temp = new Node(d1 - d2);
            temp.next = res;
            res = temp;
            head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        res = removeLeadingZero(res);
        return res;
    }
}
