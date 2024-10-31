class Solution {
    public Node sortedInsert(Node head, int x) {
        Node newNode = new Node(x);

        // If the list is empty
        if (head == null) {
            return newNode;
        }

        // If the new node needs to be inserted before the head
        if (head.data >= x) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        Node prev = null;
        Node temp = head;

        while (temp != null) {
            if (temp.data < x) {
                prev = temp;
                temp = temp.next;
            } else {
                // Insert the new node before temp
                newNode.prev = prev;
                newNode.next = temp;

                if (prev != null) {
                    prev.next = newNode;
                }
                if (temp != null) {
                    temp.prev = newNode;
                }
                return head;
            }
        }

        // If we reached the end, append the new node
        prev.next = newNode;
        newNode.prev = prev;

        return head;
    }
}
