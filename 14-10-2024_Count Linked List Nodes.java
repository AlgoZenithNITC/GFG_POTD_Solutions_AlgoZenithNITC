class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        int count = 0;

        // using a pointer for the linked list.
        Node current = head;

        // using a loop to count nodes until we get null in link part of node.
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
