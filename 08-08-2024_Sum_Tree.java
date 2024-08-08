class Solution {
    /* Utility function to check if the given node is leaf or not */
    boolean isLeaf(Node node) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return true;
        return false;
    }

    /* returns 1 if SumTree property holds for the given
       tree */
    boolean isSumTree(Node node) {
        int ls; // for sum of nodes in left subtree
        int rs; // for sum of nodes in right subtree

        /* If node is NULL or it's a leaf node then
         return true */
        if (node == null || isLeaf(node) == true) return true;

        if (isSumTree(node.left) != false && isSumTree(node.right) != false) {
            // Get the sum of nodes in left subtree
            if (node.left == null)
                ls = 0;
            else if (isLeaf(node.left) != false)
                ls = node.left.data;
            else
                ls = 2 * (node.left.data);

            // Get the sum of nodes in right subtree
            if (node.right == null)
                rs = 0;
            else if (isLeaf(node.right) != false)
                rs = node.right.data;
            else
                rs = 2 * (node.right.data);

            /* If root's data is equal to sum of nodes in left
               and right subtrees then return 1 else return 0*/
            if ((node.data == rs + ls))
                return true;
            else
                return false;
        }

        return false;
    }
}
