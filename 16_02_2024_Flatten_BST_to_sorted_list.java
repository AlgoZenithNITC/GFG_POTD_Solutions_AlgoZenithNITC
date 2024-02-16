class Pair{
    Node head;
    Node tail;
    Pair(Node h,Node t){
        head = h;
        tail = t;
    }
}
class Solution {
    private Pair helper(Node root){
        if(root==null)
            return new Pair(null,null);
        
        Pair leftP = helper(root.left);
        Pair rightP = helper(root.right);
        
        Pair ans = new Pair(root,root);
        if(leftP.head!=null){
            leftP.tail.right = root;
            ans.head = leftP.head;
        }
        if(rightP.tail!=null){
            root.right = rightP.head;
            ans.tail = rightP.tail;
        }
        root.left=null;
        return ans;
    }
    public Node flattenBST(Node root) {
        // Code here
        Pair ans = helper(root);
        return ans.head;
    }
}
