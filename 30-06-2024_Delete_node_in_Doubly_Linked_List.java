class Solution {
    public Node deleteNode(Node head, int x) {
        Node del = head;
        x = x - 1;
        while (x-- > 0) del = del.next;

        /* base case */
        // if head_ref or del is null, return null.
        if (head == null || del == null) return null;

        /* If Node to be deleted is head Node */
        // if del is equal to head_ref, update head_ref to next node.
        if (head == del) head = del.next;

        /* Change next only if Node to be deleted is NOT the last Node */
        // if del next is not null, update previous node of del next to del previous.
        if (del.next != null) del.next.prev = del.prev;

        /* Change prev only if Node to be deleted is NOT the first Node */
        // if del previous is not null, update next node of del previous to del next.
        if (del.prev != null) del.prev.next = del.next;

        // return updated head_ref.
        return head;
    }
}
