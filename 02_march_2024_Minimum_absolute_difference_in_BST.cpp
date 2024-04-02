/*The Node structure is defined as
struct Node {
    int data;
    Node *left;
    Node *right;

};
*/

class Solution
{
    public:
    int res = INT_MAX , prev =0;
    
    void find(Node* root ){
        if(root==nullptr) return;
        
        find(root->left);
        if(prev>0) res = min(res , abs(root->data-prev));
        prev = root->data;
        find(root->right);
        
    }
    int absolute_diff(Node *root)
    {
        //Your code here
       
        find(root);
        
        return res ;
    }
};
