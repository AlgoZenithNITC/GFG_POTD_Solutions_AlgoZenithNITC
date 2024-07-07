class Solution {
    // Utility method to check if target is present in ancestors of a node
    public boolean AncestorsUtil(Node node, int target, ArrayList<Integer> nodes) {
        // If the node is null, return false
        if (node == null) return false;

        // If the data of the node is equal to the target, return true
        if (node.data == target) return true;

        // Recursively check the left and right subtree for the target
        // If target is found in either subtree, add the node's data to ancestors list
        if (AncestorsUtil(node.left, target, nodes) ||
            AncestorsUtil(node.right, target, nodes)) {
            nodes.add(node.data);
            return true;
        }

        // If target is not found in the subtree, return false
        return false;
    }

    // Method to find the ancestors of a target node in a binary tree
    public ArrayList<Integer> Ancestors(Node root, int target) {
        // Create an ArrayList to store the ancestors of the target node
        ArrayList<Integer> nodes = new ArrayList<Integer>();

        // Call the utility method to find the ancestors
        AncestorsUtil(root, target, nodes);

        // Return the ArrayList containing the ancestors
        return nodes;
    }
}
