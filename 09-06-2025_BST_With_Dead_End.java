import java.util.*;

class Node {
    int data;
    Node left, right;
    
    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Solution {
    static class Triple {
        Node node;
        int min, max;

        Triple(Node node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isDeadEnd(Node root) {
        if (root == null)
            return false;

        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(root, 1, (int)1e5));

        while (!q.isEmpty()) {
            Triple t = q.poll();
            Node cur = t.node;
            int min = t.min;
            int max = t.max;

            if (cur.left == null && cur.right == null && min == max) {
                return true;
            }

            if (cur.left != null) {
                q.add(new Triple(cur.left, min, cur.data - 1));
            }

            if (cur.right != null) {
                q.add(new Triple(cur.right, cur.data + 1, max));
            }
        }

        return false;
    }
}
