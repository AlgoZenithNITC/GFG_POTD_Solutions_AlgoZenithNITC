

// User function Template for Java

/*

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

*/

class Solution {
    Node solve(Node root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        
        root.left = solve(root.left);
        root.right = solve(root.right);
        
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        
        return root;
    }

    public Node RemoveHalfNodes(Node root) {
        // code here
        return solve(root);
    }
}
