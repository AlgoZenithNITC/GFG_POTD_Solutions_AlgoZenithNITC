class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<Integer, Integer> hdNodeMap = new TreeMap<>();
        Map<Node, Integer> nodeHdMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        nodeHdMap.put(root, 0);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int hd = nodeHdMap.get(temp);
            
            hdNodeMap.put(hd, temp.data);

            if (temp.left != null) {
                queue.add(temp.left);
                nodeHdMap.put(temp.left, hd - 1);
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nodeHdMap.put(temp.right, hd + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hdNodeMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
