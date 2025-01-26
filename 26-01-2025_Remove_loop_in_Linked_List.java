class Solution 
{
    // Function to remove a loop in the linked list.
       static void removeLoop(Node head) 
       {

        // hash set to hash addresses of
        // the linked list nodes
        HashSet<Node> st = new HashSet<>();

        // pointer to prev node
        Node prev = null;
        while (head != null) {

            // if node not present in the map,
            // insert it in the map
            if (!st.contains(head)) {
                st.add(head);
                prev = head;
                head = head.next;
            }

            // if present, it is a cycle, make
            // last node's next pointer NULL
            else {
                prev.next = null;
                break;
            }
        }
    }
}