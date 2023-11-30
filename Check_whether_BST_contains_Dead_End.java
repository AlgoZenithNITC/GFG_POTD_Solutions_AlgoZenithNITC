class Solution{
    public static boolean hasDeadEnd(Node root, int minVal, int maxVal) {
        if (root == null) {
            return false;
        }
        if (minVal == maxVal) {
            return true;
        }
        return hasDeadEnd(root.left, minVal, root.data - 1) ||
            hasDeadEnd(root.right, root.data + 1, maxVal);
    }
    public static boolean isDeadEnd(Node root){
        return hasDeadEnd(root, 1, 10001);
    }
}
