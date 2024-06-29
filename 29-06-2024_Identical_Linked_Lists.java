class Solution {
    // Function to check whether two linked lists are identical or not.
    public boolean areIdentical(Node head1, Node head2) {

        Node temp1 = head1, temp2 = head2;
        // traversing through both the linked lists.
        while (temp1 != null && temp2 != null) {

            // if data for current node in both lists aren't equal,
            // we return false.
            if (temp1.data != temp2.data) return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // if both lists reach end after same number of traversals
        // then true is returned else false.
        return (temp1 == null && temp2 == null);
    }
}
