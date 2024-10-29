class GfG {
    public static Node quickSort(Node head) {
        // Your code here
        if (head == null || head.next == null)
            return head;

        int pivot = head.data;
        Node lessHead = new Node(0), equalHead = new Node(0), greaterHead = new Node(0);
        Node lessTail = lessHead, equalTail = equalHead, greaterTail = greaterHead;
        Node current = head;

        while (current != null) {
            if (current.data < pivot) {
                lessTail.next = current;
                lessTail = lessTail.next;
            } else if (current.data == pivot) {
                equalTail.next = current;
                equalTail = equalTail.next;
            } else {
                greaterTail.next = current;
                greaterTail = greaterTail.next;
            }
            current = current.next;
        }

        lessTail.next = equalTail.next = greaterTail.next = null;

        Node sortedLess = quickSort(lessHead.next);
        Node sortedGreater = quickSort(greaterHead.next);

        Node sortedHead = sortedLess != null ? sortedLess : equalHead.next;
        Node tail = sortedHead;

        while (tail != null && tail.next != null)
            tail = tail.next;

        if (tail != null) tail.next = equalHead.next;
        equalTail.next = sortedGreater;

        return sortedHead;
    }
}