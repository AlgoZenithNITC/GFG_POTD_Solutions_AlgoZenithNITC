public Node reverse(Node head) {
    Node prev = null, curr = head, next = null;

    while (curr != null) {
        next = curr.next;

        curr.next = prev;
        curr.prev = next;

        prev = curr;
        curr = next;
    }

    return prev;
}
