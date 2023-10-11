class Tree {
    // Function to check whether a binary tree is balanced or not.
    public int height(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(Node root) {
        if(root == null) {
            return true;
        }
        int left_height = height(root.left);
        int right_height = height(root.right);
        if((Math.abs(left_height - right_height) == 0 || Math.abs(left_height - right_height) == 1) && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }
}
