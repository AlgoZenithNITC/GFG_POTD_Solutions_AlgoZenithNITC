

//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> list = new ArrayList<>();
      helper(root, 1, list);
      return list;
    }
    
    private void helper(Node root, int lvl, ArrayList<Integer> list){
        if(root == null) return;
        if(lvl > list.size()) list.add(root.data);
        helper(root.left, lvl+1, list);
        helper(root.right, lvl+1, list);
    }
}
