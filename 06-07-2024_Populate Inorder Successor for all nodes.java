//Back-end complete function Template for Java

class Solution {
    class Nodee {
        Node node = null; // create an object of Node class and initialize it to null
    }

    public void populateNextRecur(Node p, Nodee next_ref) {
        if (p != null) {
            populateNextRecur(
                p.right, next_ref); // recursively call the method for the right subtree

            p.next = next_ref.node; // assign the next pointer of the current node to
                                    // the node stored in next_ref

            next_ref.node = p; // update the next_ref to the current node

            populateNextRecur(
                p.left, next_ref); // recursively call the method for the left subtree
        }
        return;
    }

    public void populateNext(Node root) {
        Nodee next = new Nodee(); // create an object of Nodee class

        populateNextRecur(
            root, next); // call the recursive method to populate the next pointers
        return;
    }
}
