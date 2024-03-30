
class Solution {
  public:
    int minValue(Node* root) {
        // Code here
        if(root->left==NULL) return root->data;
        
        return minValue(root->left);
    }
};
