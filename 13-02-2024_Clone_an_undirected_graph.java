class Solution {
    Node cloneGraph(Node node) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        return cloneHelper(node, nodeMap);
    }

    Node cloneHelper(Node node, Map<Integer, Node> nodeMap) {
        if (node == null)
            return null;

        if (!nodeMap.containsKey(node.val)) {
            nodeMap.put(node.val, new Node(node.val));
            for (Node neighbor : node.neighbors) {
                if (!nodeMap.containsKey(neighbor.val)) {
                    nodeMap.get(node.val).neighbors.add(cloneHelper(neighbor, nodeMap));
                } else {
                    nodeMap.get(node.val).neighbors.add(nodeMap.get(neighbor.val));
                }
            }
        }
        return nodeMap.get(node.val);
    }

}
