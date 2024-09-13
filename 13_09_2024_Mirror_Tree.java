class Solution {
    // Function to convert a binary tree into its mirror tree.
    public void mirror(Node node) {
        if (node == null) {
            return;
        }
        
        mirror(node.left);
        mirror(node.right);
        
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

