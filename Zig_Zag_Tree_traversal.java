

//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG
{

void solve(Node root, ArrayList<Integer> temp) {
        if (root == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node curr = s1.pop();
                temp.add(curr.data);
                if (curr.left != null)
                    s2.push(curr.left);
                if (curr.right != null)
                    s2.push(curr.right);
            }

            while (!s2.isEmpty()) {
                Node curr = s2.pop();
                temp.add(curr.data);
                if (curr.right != null)
                    s1.push(curr.right);
                if (curr.left != null)
                    s1.push(curr.left);
            }
        }
    }

    // Main function to get zig-zag traversal of tree
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> temp = new ArrayList<>();
        solve(root, temp);
        return temp;
    }


}
