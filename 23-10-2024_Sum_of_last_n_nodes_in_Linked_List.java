class Solution {
    // Definition for singly-linked list
    class Node {
        int data;
        Node next;
        
        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Function to return the sum of the last n nodes
    public int sumOfLastN_Nodes(Node head, int n) {
        int sum = 0;
        int count = 0;
        Node ptr = head;
        
        // Count the total number of nodes in the list
        while (ptr != null) {
            ptr = ptr.next;
            count++;
        }

        // Move the pointer to the (count - n)th node
        int i = 0;
        ptr = head;
        while (i < count - n) {
            ptr = ptr.next;
            i++;
        }

        // Sum the last n nodes
        for (i = 0; i < n; i++) {
            sum += ptr.data;
            ptr = ptr.next;
        }
        
        return sum;
    }
}
