class Compare implements java.util.Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.data - b.data;
    }
}

public class GfG {

    // function to sort a k sorted doubly linked list
    static Node sortAKSortedDLL(Node head, int k) {

        // if list is empty
        if (head == null)
            return head;

        // priority_queue 'pq' implemented as min 
        // heap with the help of 'compare' function
        PriorityQueue<Node> pq = 
          new PriorityQueue<>(new Compare());

        Node newHead = null, last = null;

        // Create a Min Heap of first (k+1) 
        // elements from input doubly linked list
        for (int i = 0; head != null && 
             i < k + 1; i++) {
            pq.add(head);

            head = head.next;
        }

        while (!pq.isEmpty()) {

            if (newHead == null) {
                newHead = pq.poll();
                newHead.prev = null;

                // 'last' points to the last node
                // of the result sorted list so far
                last = newHead;
            } else {
                last.next = pq.poll();
                last.next.prev = last;
                last = last.next;
            }

            // if there are more nodes left in 
              // the input list
            if (head != null) {
                pq.add(head);
                head = head.next;
            }
        }

        // making 'next' of last node point to NULL
        last.next = null;

        // new head of the required sorted DLL
        return newHead;
    }
  
}
