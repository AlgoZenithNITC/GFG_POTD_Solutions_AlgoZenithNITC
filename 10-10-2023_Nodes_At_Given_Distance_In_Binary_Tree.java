class Solution {
    public static Node findNode(Node root, int target) {
        if (root == null || root.data == target)
            return root;

        Node left = findNode(root.left, target);
        Node right = findNode(root.right, target);

        return left != null ? left : right;
    }

    public static void markParent(Node root, Map<Node, Node> parent_track, int target) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                parent_track.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent_track.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        HashMap<Node, Node> parent_track = new HashMap<>();
        markParent(root, parent_track, target);

        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(findNode(root, target));
        visited.put(findNode(root, target), true);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k)
                break;
            level++;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null && visited.get(curr.left) == null) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }

                if (curr.right != null && visited.get(curr.right) == null) {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Node curr = q.poll();
            ans.add(curr.data);
        }
        Collections.sort(ans);
        return ans;
    }
}
