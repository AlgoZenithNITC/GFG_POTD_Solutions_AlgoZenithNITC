class Solution {
    private int lmao = 1;

    public int kthSmallest(Node root, int k) {
        if (root == null) {
            return -1;
        }

        int res = kthSmallest(root.left, k);
        if (res != -1) {
            return res;
        }

        if (lmao == k) {
            return root.data;
        } else {
            lmao++;
        }

        res = kthSmallest(root.right, k);
        return res;
    }
}
