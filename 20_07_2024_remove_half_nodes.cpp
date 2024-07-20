/*Complete the function below
Node is as follows:
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/

// Return the root of the modified tree after removing all the half nodes.

Node* solve(Node* root){
    if(root==NULL) return NULL;
    if(root->left==NULL and root->right==NULL) return root ;
    
    root->left = solve(root->left);
    root->right = solve(root->right);
    
    if(root->left==NULL) return root->right;
    if(root->right==NULL) return root->left;
    
    return root ;
}

class Solution {
  public:
    Node *RemoveHalfNodes(Node *root) {
        // code here
        
        return solve(root);
        
    }
};
