// Node Structure
class Node {
    public int data;
    public Node left, right;

    public Node(int x) {
        data = x;
        left = right = null;
    }
}

class GFG {
  
    //function to find the number of
    // moves to distribute all of the candies
    static int distCandyUtil(Node root, int[] ans) {

        if (root == null)
            return 0;

        // Traverse left subtree
        int l = distCandyUtil(root.left, ans);

        // Traverse right subtree
        int r = distCandyUtil(root.right, ans);

        ans[0] += Math.abs(l) + Math.abs(r);

        // Return number of moves to balance
        // current node
        return root.data + l + r - 1;
    }

    // Function to find the number of moves 
    static int distCandy(Node root) {
        int[] ans = new int[1];

        distCandyUtil(root, ans);

        return ans[0];
    }

    public static void main(String[] args) {
        
        // Representation of given Binary Tree
//        5
//       / \
//      0   0
//         / \
//        0   0
        Node root = new Node(5);
        root.left = new Node(0);
        root.right = new Node(0);
        root.right.left = new Node(0);
        root.right.right = new Node(0);

        System.out.println(distCandy(root));
    }
}
