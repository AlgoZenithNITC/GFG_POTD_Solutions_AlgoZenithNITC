
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        if(root.left==null) return root.data;
        return minValue(root.left);
    }
}
