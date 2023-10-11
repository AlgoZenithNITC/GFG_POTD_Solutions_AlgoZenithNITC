class Solution{
    public:
    //Function to check whether a binary tree is balanced or not.
    int height(Node *root){
        if(root == NULL){
            return 0;
        }
        return 1 + max(height(root -> left), height(root -> right));
    }
    bool isBalanced(Node *root){
        if(root == NULL){
            return true;
        }
        int left_height = height(root -> left);
        int right_height = height(root -> right);
        if((abs(left_height - right_height) == 0 or abs(left_height - right_height) == 1) and isBalanced(root -> left) and isBalanced(root -> right)){
            return true;
        }
        return false;
    }
};
