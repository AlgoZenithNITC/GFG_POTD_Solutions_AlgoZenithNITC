class Solution {
    public Node sortedMerge(Node head1, Node head2) {
        // Initialize pointers for the new merged list
        Node head3 = null; // Head of the merged list
        Node temp = null;  // Temporary pointer to track the tail of the merged list

        // Traverse both lists while there are nodes in both
        while (head1 != null && head2 != null) {
            if (head3 == null) {
                if (head1.data > head2.data) {
                    head3 = head2;
                    head2 = head2.next;
                } else {
                    head3 = head1;
                    head1 = head1.next;
                }
                temp = head3;
            } else {
                if (head1.data > head2.data) {
                    temp.next = head2;
                    head2 = head2.next;
                } else {
                    temp.next = head1;
                    head1 = head1.next;
                }
                temp = temp.next;
            }
        }

        // Attach the remaining nodes of either list
        if (head1 != null) {
            temp.next = head1;
        } else if (head2 != null) {
            temp.next = head2;
        }

        return head3;
    }
}