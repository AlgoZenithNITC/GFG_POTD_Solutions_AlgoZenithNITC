class Solution {
    
     private boolean recSym(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.data != q.data) {
            return false;
        }

        return recSym(p.left, q.right) && recSym(p.right, q.left);
    }
    public boolean isSymmetric(Node root) {
        // Code here
         if (root == null) return true;
        return recSym(root.left, root.right);
    }
}
