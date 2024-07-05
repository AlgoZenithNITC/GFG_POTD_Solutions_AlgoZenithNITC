class Pair<U, V> {
    private U key;
    private V value;

    public Pair(U key, V value) {
            this.key = key;
            this.value = value;
    }

    public U getKey() { return key; }
    public V getValue() { return value; }
}

class Solution {
    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(Node root) {
        // code here.
        if (root == null)
            return 0;

        int maxLevel = 0, minLevel = 0;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> temp = q.poll();
            Node cur = temp.getKey();
            int count = temp.getValue();

            if (cur.left != null) {
                minLevel = Math.min(minLevel, count - 1);
                q.add(new Pair<>(cur.left, count - 1));
            }
            if (cur.right != null) {
                maxLevel = Math.max(maxLevel, count + 1);
                q.add(new Pair<>(cur.right, count + 1));
            }
        }

        return maxLevel + Math.abs(minLevel) + 1;
    }
}
