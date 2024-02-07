class GfG {
    Node findNearestCommonRoot(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b)
            return root;

        Node l = findNearestCommonRoot(root.left, a, b);
        Node r = findNearestCommonRoot(root.right, a, b);

        if (l == null)
            return r;
        else if (r == null)
            return l;
        else
            return root;
    }

    int findDistance(Node root, int n) {
        if (root == null)
            return 0;

        if (root.data == n)
            return 1;

        int p = findDistance(root.left, n);
        int q = findDistance(root.right, n);

        if (p == 0 && q == 0)
            return 0;

        return p + q + 1;
    }

    int findDist(Node root, int a, int b) {
        Node LCA = findNearestCommonRoot(root, a, b);

        return findDistance(LCA, a) + findDistance(LCA, b) - 2;
    }
}
