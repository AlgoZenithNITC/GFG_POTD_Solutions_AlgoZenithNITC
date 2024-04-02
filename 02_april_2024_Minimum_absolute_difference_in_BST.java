

//User function Template for Java

/*The Node structure is defined as
struct Node {
    int data;
    Node *left;
    Node *right;

};
*/
class Solution
{
    int res = Integer.MAX_VALUE;
    int prev =0;
    
    void find(Node root ){
        if(root==null) return;
        
        find(root.left);
        if(prev>0) res = Math.min(res,Math.abs(root.data-prev));
        prev = root.data;
        find(root.right);
    }
    int absolute_diff(Node root)
    {
        //Your code here
        find(root);
        return res ;
    }
}
