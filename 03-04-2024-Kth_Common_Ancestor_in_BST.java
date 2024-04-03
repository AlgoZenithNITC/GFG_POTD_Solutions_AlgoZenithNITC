import java.util.*;

class Solution {
    public int fun(Node root, int x, int y, int[] k) {
        if (root == null) {
            return -1;
        }
        int val = -1;
        if ((root.data > x) && (root.data > y)) {
            val = fun(root.left, x, y, k);
        } else if ((root.data < x) && (root.data < y)) {
            val = fun(root.right, x, y, k);
        }
        k[0]--;
        if (k[0] == 0) {
            val = root.data;
        }
        return val;
    }

    public int kthCommonAncestor(Node root, int k, int x, int y) {
        int[] kArr = {k};
        return fun(root, x, y, kArr);
    }
}

