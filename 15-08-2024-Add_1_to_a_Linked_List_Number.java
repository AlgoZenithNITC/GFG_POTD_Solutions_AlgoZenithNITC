class Solution {
    public Node reverse(Node head)
    // this function reverses the linked list
    {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next; // storing next node
            current.next = prev; // linking current node to previous
            prev = current;      // updating prev
            current = next;      // updating current
        }

        return prev;
    }

    public Node addOne(Node head) {
        head = reverse(head); // reversing list to make addition easy

        Node current = head;
        int carry = 1;

        while (carry != 0) {
            current.data += 1; // adding one to current node

            if (current.data < 10) return reverse(head);
            // if no carry we can reverse back list and return it
            else
                current.data = 0;
            // else we continue with taking carry forward

            if (current.next == null) break;
            // if, end of list, we break from loop
            else
                current = current.next;
            // else we move to next node
        }

        current.next = new Node(1); // adding new node for the carried 1
        return reverse(head);
    }
}
