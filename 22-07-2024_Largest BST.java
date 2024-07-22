//Back-end complete function Template for Java

class Node1
{
    boolean isBst; // a flag to indicate if the subtree rooted at the current node is a valid BST
    int size; // the size of the largest BST found so far
    int mini; // the minimum value in the subtree rooted at the current node
    int maxi; // the maximum value in the subtree rooted at the current node
    
    public Node1(boolean isBst, int size, int mini, int maxi)
    {
        this.isBst = isBst;
        this.size = size;
        this.mini = mini;
        this.maxi = maxi;
    }
}

class Solution{
    
    static Node1 bst(Node root)
    {
        Node1 x; // create a new Node1 object
        if(root == null) // base case: if the root is null
        {
            x = new Node1(true, 0, 1000000, 0); // return a Node1 object with isBst=true, size=0, mini=1000000, maxi=0
            return x; // return the Node1 object
        }
        
        Node1 left = bst(root.left); // recursively check the left subtree
        Node1 right = bst(root.right); // recursively check the right subtree
        if(left.isBst && right.isBst && root.data > left.maxi && root.data < right.mini) // if the current node is a valid BST based on its children and its value is within the correct range
            x = new Node1(true, 1+left.size+right.size, Math.min(root.data, left.mini), Math.max(root.data, right.maxi)); // update x with isBst=true, size=1+left.size+right.size, mini=min(root.data, left.mini), maxi=max(root.data, right.maxi)
        else
            x = new Node1(false, Math.max(left.size, right.size), 1000000, 0); // update x with isBst=false, size=max(left.size, right.size), mini=1000000, maxi=0
        
        return x; // return the updated Node1 object
    }
    
    static int largestBst(Node root)
    {
        return bst(root).size; // return the size of the largest BST found in the given binary tree
    }
      

}
