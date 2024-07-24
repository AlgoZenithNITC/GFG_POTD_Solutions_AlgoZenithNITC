import java.util.Objects;

class Solution {
    private Integer prev;

    // Function to check whether a Binary Tree is BST or not.
    public boolean isBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!inorder(root.left)) {
            return false;
        }

        // Check BST condition
        if (prev != null && root.data <= prev) {
            return false;
        }

        prev = root.data; // update prev to current node's value

        return inorder(root.right);
    }
}

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

