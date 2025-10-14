/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/
class Solution {
    int s;

    int nodeSum(Node root, int l, int r) {
        s = 0;
        recurse(root, l, r);
        return s;
    }

    void recurse(Node root, int l, int r) {
        if (root != null) {
            if (l <= root.data && root.data <= r)
                s += root.data;
            recurse(root.left, l, r);
            recurse(root.right, l, r);
        }
    }
}
